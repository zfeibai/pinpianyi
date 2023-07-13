package com.feibai.framework.state.condition;

import lombok.*;

/**
 * 流程动作触发条件
 *
 * @author zhaofeixiang@pinpianyi.com
 * @since 2023/7/10 09:56
 */
@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ActionCondition<S, E> {
    /**
     * 流程事件前状态
     */
    private S fromState;

    /**
     * 流程事件
     */
    private E event;

    /**
     * 流程事件后状态
     */
    private S toState;
}
