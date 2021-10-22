package com.slightlee.sms.strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FactoryStrategy {


    /**
     * 存储策略
     */
    private static Map<String, SendSmsStrategy> strategyMap = new ConcurrentHashMap<>();


    /**
     * 初始化策略
     */
    static {
        strategyMap.put("Aliyun", new AliyunSendSmsStrategy());
    }

    /**
     * 执行具体策略
     * @param strategyId
     * @return
     */
    public static SendSmsStrategy getStrategy(String strategyId) {
        return strategyMap.get(strategyId);
    }
}
