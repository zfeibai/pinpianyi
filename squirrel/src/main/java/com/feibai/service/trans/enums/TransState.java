package com.feibai.service.trans.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 物流状态
 *
 * @author zhaofeixiang@pinpianyi.com
 * @since 2023/7/7 16:32
 */
@Getter
@AllArgsConstructor
public enum TransState {
    NEW(0, "新建"),
    START(1, "启动"),
    READY(2, "就绪"),
    RUNNING(3, "运行中"),
    WAITING(4, "等待锁"),
    SUCCESS(5, "执行成功"),
    FAILURE(6, "执行失败"),
    COMMIT(7, "提交"),
    ROLLBACK(8, "回滚"),
    TIDYING(9, "完成"),
    TERMINATED(-1, "结束");

    private final Integer code;
    private final String name;
}
