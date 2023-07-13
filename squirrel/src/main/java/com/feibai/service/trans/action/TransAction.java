package com.feibai.service.trans.action;

import com.feibai.framework.state.action.Action;
import com.feibai.service.trans.enums.TransEvent;
import com.feibai.service.trans.enums.TransState;

/**
 * 物流操作
 *
 * @author zhaofeixiang@pinpianyi.com
 * @since 2023/7/12 17:13
 */
public abstract class TransAction implements Action<TransState, TransEvent, Object> {

}
