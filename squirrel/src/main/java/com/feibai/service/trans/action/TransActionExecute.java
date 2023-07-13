package com.feibai.service.trans.action;

import com.alibaba.fastjson.JSONObject;
import com.feibai.framework.state.condition.ActionCondition;
import com.feibai.service.trans.enums.TransEvent;
import com.feibai.service.trans.enums.TransState;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * 物流执行
 *
 * @author zhaofeixiang@pinpianyi.com
 * @since 2023/7/12 16:48
 */
@Slf4j
@Component
public class TransActionExecute extends TransAction {
    @Override
    public List<ActionCondition<TransState, TransEvent>> matchConditions() {
        ActionCondition<TransState, TransEvent> executeReady = new ActionCondition<>(TransState.START, TransEvent.EXECUTE, TransState.READY);
        ActionCondition<TransState, TransEvent> executeRunning = new ActionCondition<>(TransState.READY, TransEvent.EXECUTE, TransState.RUNNING);
        return Lists.newArrayList(executeReady, executeRunning);
    }

    @Override
    public boolean process(TransState fromState, TransState toState, TransEvent TransEvent, Object context) {
        log.info("TransActionExecute doProcess fromState:{}, event:{}, toState:{}, context:{}",
                fromState, TransEvent, toState, JSONObject.toJSONString(context));
        return true;
    }

    @Override
    public boolean afterProcess(TransState fromState, TransState toState, TransEvent TransEvent, Object context) {
        log.info("TransActionExecute doAfterProcess fromState:{}, event:{}, toState:{}, context:{}",
                fromState, TransEvent, toState, JSONObject.toJSONString(context));
        if (Objects.equals(toState, TransState.READY)) {
            // TODO
        }
        return true;
    }

    @Override
    public void onException(TransState fromState, TransState toState, TransEvent TransEvent, Object context, Throwable throwable) {
        log.info("TransActionExecute onException fromState:{}, event:{}, toState:{}, context:{}, errorMsg:{}",
                fromState, TransEvent, toState, JSONObject.toJSONString(context), throwable.getMessage());
    }
}
