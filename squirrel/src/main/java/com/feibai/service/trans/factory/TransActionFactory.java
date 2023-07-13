package com.feibai.service.trans.factory;

import com.feibai.framework.state.action.Action;
import com.feibai.framework.state.factory.AbstractActionFactory;
import com.feibai.service.trans.action.TransAction;
import com.feibai.service.trans.enums.TransEvent;
import com.feibai.service.trans.enums.TransState;
import org.springframework.stereotype.Component;

/**
 * 物流事件工厂
 *
 * @author zhaofeixiang@pinpianyi.com
 * @since 2023/7/12 17:12
 */
@Component
public class TransActionFactory extends AbstractActionFactory<TransState, TransEvent, Object> {

    @Override
    public <A extends Action<TransState, TransEvent, Object>> Class<A> targetActionClass() {
        return (Class<A>) TransAction.class;
    }
}
