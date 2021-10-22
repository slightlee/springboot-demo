package com.slightlee.sms.service;

import com.slightlee.sms.strategy.FactoryStrategy;
import com.slightlee.sms.strategy.SendSmsStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class SmsService {


    // 发送短信
    public boolean send(Map<String, Object> param, String phone) {

        // 使用阿里云发送短信
        SendSmsStrategy aliyun = FactoryStrategy.getStrategy("Aliyun");
        log.info("使用阿里云发送短信......");
        return aliyun.send(param, phone);
    }
}
