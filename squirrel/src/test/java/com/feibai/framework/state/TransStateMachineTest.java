package com.feibai.framework.state;

import com.feibai.Bootstrap;
import com.feibai.service.order.enums.OrderEvent;
import com.feibai.service.order.enums.OrderState;
import com.feibai.service.order.factory.OrderMachineFactory;
import com.feibai.service.order.machine.OrderMachine;
import com.feibai.service.trans.enums.TransEvent;
import com.feibai.service.trans.enums.TransState;
import com.feibai.service.trans.factory.TransMachineFactory;
import com.feibai.service.trans.machine.TransMachine;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * TODO 类描述说明
 *
 * @author zhaofeixiang@pinpianyi.com
 * @since 2023/7/13 09:43
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Bootstrap.class)
public class TransStateMachineTest {

    @Resource
    private OrderMachineFactory orderMachineFactory;

    @Resource
    private TransMachineFactory transMachineFactory;

    @Test
    public void orderTest() {
        OrderMachine orderMachine = orderMachineFactory.createMachine(OrderState.NEW);
        log.info("执行前状态机初始状态：{}", orderMachine.getInitialState());
        orderMachine.fire(OrderEvent.PAY, "订单");
        log.info("执行后状态机当前状态：{}, 上一状态:{}", orderMachine.getCurrentState(), orderMachine.getLastState());
    }

    @Test
    public void transTest() {
        TransMachine transMachine = transMachineFactory.createMachine(TransState.NEW);
        log.info("执行前状态机初始状态：{}", transMachine.getInitialState());
        // 启动方法默认会在 fire 方法中调用
        // transMachine.start();
        transMachine.fire(TransEvent.START, "物流");
        log.info("执行后状态机当前状态：{}, 上一状态:{}", transMachine.getCurrentState(), transMachine.getLastState());

    }

}
