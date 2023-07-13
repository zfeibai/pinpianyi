package com.feibai.service.order.action;

import com.alibaba.fastjson.JSONObject;
import com.feibai.framework.state.condition.ActionCondition;
import com.feibai.service.order.enums.OrderEvent;
import com.feibai.service.order.enums.OrderState;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 订单操作
 *
 * @author zhaofeixiang@pinpianyi.com
 * @since 2023/7/13 10:14
 */
@Slf4j
@Component
public class OrderActionPack extends OrderAction {

    /**
     * 可操作的流程条件
     *
     * @return 流程条件列表
     */
    @Override
    public List<ActionCondition<OrderState, OrderEvent>> matchConditions() {
        ActionCondition<OrderState, OrderEvent> actionCondition = new ActionCondition(OrderState.PAYMENT, OrderEvent.PACK, OrderState.PACKAGE);
        return Lists.newArrayList(actionCondition);
    }

    /**
     * 流程环节执行业务
     *
     * @param fromState
     * @param toState
     * @param event     流程事件
     * @param context   流程上下文
     * @return 执行结果
     */
    @Override
    public boolean process(OrderState fromState, OrderState toState, OrderEvent event, Object context) {
        log.info("OrderActionPack process fromState:{}, event:{}, toState:{}, context:{}",
                fromState, event, toState, JSONObject.toJSONString(context));
        return true;
    }

    /**
     * 流程环节执行后业务
     *
     * @param fromState 流程环节前状态
     * @param toState   流程环节后状态
     * @param event     流程事件
     * @param context   流程上下文
     * @return 执行结果
     */
    @Override
    public boolean afterProcess(OrderState fromState, OrderState toState, OrderEvent event, Object context) {
        log.info("OrderActionPack afterProcess fromState:{}, event:{}, toState:{}, context:{}",
                fromState, event, toState, JSONObject.toJSONString(context));
        return true;
    }

    /**
     * 流程环节执行异常业务
     *
     * @param fromState 流程环节前状态
     * @param toState   流程环节后状态
     * @param event     流程事件
     * @param context   流程上下文
     * @param throwable 异常
     */
    @Override
    public void onException(OrderState fromState, OrderState toState, OrderEvent event, Object context, Throwable throwable) {
        log.info("OrderActionPack onException fromState:{}, event:{}, toState:{}, context:{}, errorMsg:{}",
                fromState, event, toState, JSONObject.toJSONString(context), throwable.getMessage());

    }
}
