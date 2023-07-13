package com.feibai.service.order.factory;

import com.feibai.framework.state.action.Action;
import com.feibai.framework.state.factory.AbstractActionFactory;
import com.feibai.service.order.action.OrderAction;
import com.feibai.service.order.enums.OrderEvent;
import com.feibai.service.order.enums.OrderState;
import com.feibai.service.trans.action.TransAction;
import com.feibai.service.trans.enums.TransEvent;
import com.feibai.service.trans.enums.TransState;
import org.springframework.stereotype.Component;

/**
 * 物流事件工厂
 *
 * @author zhaofeixiang@pinpianyi.com
 * @since 2023/7/12 17:12
 */
@Component
public class OrderActionFactory extends AbstractActionFactory<OrderState, OrderEvent, Object> {

    @Override
    public <A extends Action<OrderState, OrderEvent, Object>> Class<A> targetActionClass() {
        return (Class<A>) OrderAction.class;
    }
}
