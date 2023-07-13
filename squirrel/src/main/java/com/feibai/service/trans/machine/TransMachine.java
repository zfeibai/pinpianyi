package com.feibai.service.trans.machine;

import com.feibai.framework.state.machine.AbstractMachine;
import com.feibai.service.trans.enums.TransEvent;
import com.feibai.service.trans.enums.TransState;
import com.feibai.service.trans.factory.TransActionFactory;

/**
 * 物流状态机
 *
 * @author zhaofeixiang@pinpianyi.com
 * @since 2023/7/12 17:15
 */
public class TransMachine extends AbstractMachine<TransMachine, TransState, TransEvent, Object> {

    public TransMachine(TransActionFactory actionFactory) {
        super(actionFactory);
    }

    @Override
    public void doAction(TransState fromTransState, TransState toTransState, TransEvent TransEvent, Object context) {
        super.doAction(fromTransState, toTransState, TransEvent, context);
    }
}
