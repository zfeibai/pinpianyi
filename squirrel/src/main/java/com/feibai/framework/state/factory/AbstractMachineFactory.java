package com.feibai.framework.state.factory;

import com.feibai.framework.state.machine.AbstractMachine;
import org.springframework.context.ApplicationContext;
import org.squirrelframework.foundation.fsm.StateMachineBuilder;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * TODO 类描述说明
 *
 * @author zhaofeixiang@pinpianyi.com
 * @since 2023/7/11 14:11
 */
public abstract class AbstractMachineFactory<T extends AbstractMachine<T, S, E, C>, F extends AbstractActionFactory<S, E, C>, S, E, C> {

    private final static String MACHINE_ACTION_METHOD = "doAction";

    @Resource
    private ApplicationContext applicationContext;

    protected T createMachine(Class<T> machineClazz,
                              Class<S> stateClazz, Class<E> eventClazz, Class<C> contextClazz,
                              Class<F> actionFactoryClazz, S initialState) {
        StateMachineBuilder<T, S, E, C> machineBuilder = StateMachineBuilderFactory.create(machineClazz, stateClazz, eventClazz, contextClazz, actionFactoryClazz);
        AbstractActionFactory<S, E, C> actionFactory = applicationContext.getBean(actionFactoryClazz);
        actionFactory.getConditionActionMap().forEach(((actionCondition, action) -> {
            S fromState = actionCondition.getFromState();
            E event = actionCondition.getEvent();
            S toState = actionCondition.getToState();
            if (Objects.isNull(fromState) || Objects.isNull(event)) {
                throw new RuntimeException("状态机创建失败");
            }
            if (Objects.isNull(toState) || Objects.equals(fromState, toState)) {
                machineBuilder.internalTransition().within(fromState).on(event).callMethod(MACHINE_ACTION_METHOD);
                return;
            }
            machineBuilder.externalTransition().from(fromState).to(toState).on(event).callMethod(MACHINE_ACTION_METHOD);
        }));
        return machineBuilder.newStateMachine(initialState, actionFactory);
    }

    public abstract AbstractMachine<T, S, E, C> createMachine(S initialState);
}
