package com.feibai.service.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 订单事件
 *
 * @author zhaofeixiang@pinpianyi.com
 * @since 2023/7/13 10:14
 */
@Getter
@AllArgsConstructor
public enum OrderEvent {
    ORDER("ORDER", "下单"),
    PAY("PAY", "支付"),
    PACK("PACK", "打包"),
    SHIP("SHIP", "发货"),
    SIGN("SIGN", "签收");

    private final String code;
    private final String name;
}
