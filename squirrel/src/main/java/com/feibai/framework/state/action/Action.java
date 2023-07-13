package com.feibai.framework.state.action;

import com.feibai.framework.state.condition.ActionCondition;

import java.util.List;

/**
 * 流程操作
 *
 * @author zhaofeixiang@pinpianyi.com
 * @since 2023/7/10 09:56
 */
public interface Action<S, E, C> {

    /**
     * 可操作的流程条件
     *
     * @return 流程条件列表
     */
    List<ActionCondition<S, E>> matchConditions();

    /**
     * 流程环节执行业务
     *
     * @param event   流程事件
     * @param context 流程上下文
     * @return 执行结果
     */
    boolean process(S fromState, S toState, E event, C context);

    /**
     * 流程环节执行后业务
     *
     * @param fromState 流程环节前状态
     * @param toState   流程环节后状态
     * @param event     流程事件
     * @param context   流程上下文
     * @return 执行结果
     */
    boolean afterProcess(S fromState, S toState, E event, C context);

    /**
     * 流程环节执行异常业务
     *
     * @param fromState 流程环节前状态
     * @param toState   流程环节后状态
     * @param event     流程事件
     * @param context   流程上下文
     * @param throwable 异常
     */
    void onException(S fromState, S toState, E event, C context, Throwable throwable);
}
