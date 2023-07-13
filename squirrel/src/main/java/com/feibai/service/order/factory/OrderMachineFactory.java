package com.feibai.service.order.factory;

import com.feibai.framework.state.factory.AbstractMachineFactory;
import com.feibai.service.order.enums.OrderEvent;
import com.feibai.service.order.enums.OrderState;
import com.feibai.service.order.machine.OrderMachine;
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
public class OrderMachineFactory extends AbstractMachineFactory<OrderMachine, OrderActionFactory, OrderState, OrderEvent, Object> {

    @Override
    public OrderMachine createMachine(OrderState initialOrderState) {
        OrderMachine orderMachine = super.createMachine(OrderMachine.class, OrderState.class, OrderEvent.class, Object.class, OrderActionFactory.class, initialOrderState);
//      transMachine.addListener(... ...);
        return orderMachine;
    }
}
