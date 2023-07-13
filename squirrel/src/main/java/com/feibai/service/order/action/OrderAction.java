package com.feibai.service.order.action;

import com.feibai.framework.state.action.Action;
import com.feibai.service.order.enums.OrderEvent;
import com.feibai.service.order.enums.OrderState;

/**
 * 订单操作
 *
 * @author zhaofeixiang@pinpianyi.com
 * @since 2023/7/13 10:14
 */
public abstract class OrderAction implements Action<OrderState, OrderEvent, Object> {

}
