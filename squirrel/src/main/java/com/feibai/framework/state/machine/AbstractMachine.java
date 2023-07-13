package com.feibai.framework.state.machine;

import com.feibai.framework.state.action.Action;
import com.feibai.framework.state.condition.ActionCondition;
import com.feibai.framework.state.factory.AbstractActionFactory;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.squirrelframework.foundation.fsm.impl.AbstractStateMachine;

/**
 * @author zhaofeixiang@pinpianyi.com
 * @since 2023/7/10 10:32
 */
@Slf4j
public abstract class AbstractMachine<T extends AbstractMachine<T, S, E, C>, S, E, C> extends AbstractStateMachine<T, S, E, C> {

    @Getter
    private final AbstractActionFactory<S, E, C> actionFactory;

    public AbstractMachine(AbstractActionFactory<S, E, C> actionFactory) {
        super();
        this.actionFactory = actionFactory;
    }

    /**
     * 执行业务
     *
     * @param fromState 业务前状态
     * @param toState   业务后状态
     * @param event     业务事件
     * @param context   上下文
     */
    public void doAction(S fromState, S toState, E event, C context) {
        Action<S, E, C> action = fetchActor(fromState, toState, event, context);
        action.process(fromState, toState, event, context);
    }

    @Override
    protected void afterTransitionCompleted(S fromState, S toState, E event, C context) {
        Action<S, E, C> action = fetchActor(fromState, toState, event, context);
        action.afterProcess(fromState, toState, event, context);
    }

    @Override
    protected void afterTransitionCausedException(S fromState, S toState, E event, C context) {
        Action<S, E, C> action = fetchActor(fromState, toState, event, context);
        Throwable throwable = getLastException().getTargetException();
        action.onException(fromState, toState, event, context, throwable);
    }

    /**
     * 获取业务操作器
     *
     * @param fromState 业务前状态
     * @param toState   业务后状态
     * @param event     业务事件
     * @param context   上下文
     * @return 业务操作器
     */
    private Action<S, E, C> fetchActor(S fromState, S toState, E event, C context) {
        ActionCondition<S, E> actionCondition = new ActionCondition<>();
        actionCondition.setFromState(fromState);
        actionCondition.setEvent(event);
        actionCondition.setToState(toState);
        AbstractActionFactory<S, E, C> abstractActionFactory = getActionFactory();
        return abstractActionFactory.fetch(actionCondition);
    }
}
