package com.feibai.framework.state.factory;

import com.feibai.framework.state.action.Action;
import com.feibai.framework.state.condition.ActionCondition;
import org.springframework.context.ApplicationContext;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 流程动作工厂
 *
 * @author zhaofeixiang@pinpianyi.com
 * @since 2023/7/10 09:55
 */
public abstract class AbstractActionFactory<S, E, C> {

    /**
     * 流程动作条件触发流程动作关系
     */
    private final Map<ActionCondition<S, E>, Action<S, E, C>> conditionActionMap = new ConcurrentHashMap<>();

    /**
     * spring上下文
     */
    @Resource
    private ApplicationContext applicationContext;

    @PostConstruct
    private void init() {
        autoRegister();
    }

    /**
     * action处理class类
     *
     * @param <A> class类型
     * @return class文件
     */
    public abstract <A extends Action<S, E, C>> Class<A> targetActionClass();

    /**
     * 流程动作自动注册
     */
    private void autoRegister() {
        String[] beanNames = applicationContext.getBeanNamesForType(targetActionClass());
        for (String beanName : beanNames) {
            Action<S, E, C> actionBean = (Action<S, E, C>) applicationContext.getBean(beanName);
            register(actionBean);
        }
    }

    /**
     * 流程动作自动注册
     */
    public void register(Action<S, E, C> action) {
        List<ActionCondition<S, E>> conditions = action.matchConditions();
        if (CollectionUtils.isEmpty(conditions)) {
            return;
        }
        conditions.forEach(condition -> register(condition, action));
    }

    /**
     * 流程动作注册
     *
     * @param actionCondition 流程动作条件
     * @param action    流程动作
     */
    public void register(ActionCondition<S, E> actionCondition, Action<S, E, C> action) {
        conditionActionMap.put(actionCondition, action);
    }

    /**
     * 根据流程动作条件获取流程动作
     *
     * @param actionCondition 流程动作条件
     * @return 流程动作
     */
    public Action<S, E, C> fetch(ActionCondition<S, E> actionCondition) {
        return conditionActionMap.get(actionCondition);
    }

    /**
     * 获取条件和处理的关系
     *
     * @return map
     */
    public Map<ActionCondition<S, E>, Action<S, E, C>> getConditionActionMap() {
        return conditionActionMap;
    }
}
