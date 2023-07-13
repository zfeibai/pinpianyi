package com.feibai.service.order.machine;

import com.feibai.framework.state.machine.AbstractMachine;
import com.feibai.service.order.enums.OrderEvent;
import com.feibai.service.order.enums.OrderState;
import com.feibai.service.order.factory.OrderActionFactory;
import com.feibai.service.trans.enums.TransEvent;
import com.feibai.service.trans.enums.TransState;
import com.feibai.service.trans.factory.TransActionFactory;

/**
 * 物流状态机
 *
 * @author zhaofeixiang@pinpianyi.com
 * @since 2023/7/12 17:15
 */
public class OrderMachine extends AbstractMachine<OrderMachine, OrderState, OrderEvent, Object> {

    public OrderMachine(OrderActionFactory actionFactory) {
        super(actionFactory);
    }

    @Override
    public void doAction(OrderState fromOrderState, OrderState toOrderState, OrderEvent orderEvent, Object context) {
        super.doAction(fromOrderState, toOrderState, orderEvent, context);
    }
}
