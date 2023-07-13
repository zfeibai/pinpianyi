package com.feibai.service.trans.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 物流事件
 *
 * @author zhaofeixiang@pinpianyi.com
 * @since 2023/7/7 16:32
 */
@Getter
@AllArgsConstructor
public enum TransEvent {
    NEW("NEW", "创建", "NULL -> NEW"),
    START("START", "启动", "NEW -> START"),
    EXECUTE("EXECUTE", "执行", "START -> READY -> RUNNING"),
    LOCKING("LOCKING", "锁定", "RUNNING -> WAITING"),
    RELEASE("RELEASE", "释放", "WAITING -> RUNNING"),
    EXEC_SUCCESS("EXEC_SUCCESS", "执行成功", "RUNNING -> SUCCESS"),
    EXEC_FAILURE("EXEC_FAILURE", "执行失败", "RUNNING -> FAILURE, WAITING -> FAILURE"),
    EXEC_COMPLETE("EXEC_COMPLETE", "执行完成", "SUCCESS -> COMMIT, FAILURE -> ROLLBACK"),
    EXEC_TIDYING("EXEC_TIDYING", "执行整理", "COMMIT -> TIDYING, ROLLBACK -> TIDYING"),
    EXEC_TERMINATED("EXEC_TERMINATED", "执行结束", "TIDYING -> TERMINATED");

    private final String code;
    private final String name;
    private final String desc;
}

