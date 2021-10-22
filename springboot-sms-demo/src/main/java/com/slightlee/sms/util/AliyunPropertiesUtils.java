package com.slightlee.sms.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 读取配置文件内容
 * 当项目已启动，spring接口，spring加载之后，执行接口一个方法
 */
@Component
public class AliyunPropertiesUtils implements InitializingBean {


    @Value("${aliyun.sms.aliyunAccessKeyId}")
    private String aliyunAccessKeyId;

    @Value("${aliyun.sms.aliyunAccessKeySecret}")
    private String aliyunAccessKeySecret;

    @Value("${aliyun.sms.SignName}")
    private String SignName;

    @Value("${aliyun.sms.smsCode}")
    private String smsCode;

    //定义公开静态常量
    public static String ALIYUN_ACCESS_KEYID;
    public static String ALIYUN_ACCESS_KEYSECRET;
    public static String SIGN_NAME;
    public static String SMS_CODE;

    @Override
    public void afterPropertiesSet() throws Exception {
        ALIYUN_ACCESS_KEYID = aliyunAccessKeyId;
        ALIYUN_ACCESS_KEYSECRET = aliyunAccessKeySecret;
        SIGN_NAME = SignName;
        SMS_CODE = smsCode;
    }
}
