package com.feibai.service.trans.action;

import com.alibaba.fastjson.JSONObject;
import com.feibai.framework.state.condition.ActionCondition;
import com.feibai.service.trans.enums.TransEvent;
import com.feibai.service.trans.enums.TransState;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 物流开始
 *
 * @author zhaofeixiang@pinpianyi.com
 * @since 2023/7/12 16:48
 */
@Slf4j
@Component
public class TransActionStart extends TransAction {
    /**
     * 可操作的流程条件
     *
     * @return 流程条件列表
     */
    @Override
    public List<ActionCondition<TransState, TransEvent>> matchConditions() {
        ActionCondition<TransState, TransEvent> start = new ActionCondition<>(TransState.NEW, TransEvent.START, TransState.START);
        return Lists.newArrayList(start);
    }

    @Override
    public boolean process(TransState fromState, TransState toState, TransEvent TransEvent, Object context) {
        log.info("TransActionStart process fromState:{}, event:{}, toState:{}, context:{}",
                fromState, TransEvent, toState, JSONObject.toJSONString(context));
        return true;
    }

    @Override
    public boolean afterProcess(TransState fromState, TransState toState, TransEvent TransEvent, Object context) {
        log.info("TransActionStart afterProcess fromState:{}, event:{}, toState:{}, context:{}",
                fromState, TransEvent, toState, JSONObject.toJSONString(context));
        return true;
    }

    @Override
    public void onException(TransState fromState, TransState toState, TransEvent TransEvent, Object context, Throwable throwable) {
        log.info("TransActionStart onException fromState:{}, event:{}, toState:{}, context:{}, errorMsg:{}",
                fromState, TransEvent, toState, JSONObject.toJSONString(context), throwable.getMessage());
    }
}
