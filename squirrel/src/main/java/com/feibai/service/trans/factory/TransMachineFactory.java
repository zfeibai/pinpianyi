package com.feibai.service.trans.factory;

import com.feibai.framework.state.factory.AbstractMachineFactory;
import com.feibai.service.trans.enums.TransEvent;
import com.feibai.service.trans.enums.TransState;
import com.feibai.service.trans.machine.TransMachine;
import org.springframework.stereotype.Component;

/**
 * 物流状态机工厂
 *
 * @author zhaofeixiang@pinpianyi.com
 * @since 2023/7/12 17:18
 */
@Component
public class TransMachineFactory extends AbstractMachineFactory<TransMachine, TransActionFactory, TransState, TransEvent, Object> {

    @Override
    public TransMachine createMachine(TransState initialOrderState) {
        TransMachine transMachine = super.createMachine(TransMachine.class, TransState.class, TransEvent.class, Object.class, TransActionFactory.class, initialOrderState);
//      transMachine.addListener(... ...);
        return transMachine;
    }
}
