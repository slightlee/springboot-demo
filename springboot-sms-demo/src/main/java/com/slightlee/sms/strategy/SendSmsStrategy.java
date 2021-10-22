package com.slightlee.sms.strategy;

import java.util.Map;

public interface SendSmsStrategy {


    boolean send(Map<String, Object> param, String phone);
}
