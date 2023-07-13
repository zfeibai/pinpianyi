package com.feibai.service.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 订单状态
 *
 * @author zhaofeixiang@pinpianyi.com
 * @since 2023/7/13 10:14
 */
@Getter
@AllArgsConstructor
public enum OrderState {
    NEW(1, "已下单"),
    PAYMENT(2, "已支付"),
    PACKAGE(3, "已打包"),
    TRANS(4, "已发货"),
    SIGNED(5, "已签收");

    private final Integer code;
    private final String name;
}
