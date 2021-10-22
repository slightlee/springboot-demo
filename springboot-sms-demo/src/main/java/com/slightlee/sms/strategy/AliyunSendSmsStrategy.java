package com.slightlee.sms.strategy;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.slightlee.sms.util.AliyunPropertiesUtils;

import java.util.Map;

/**
 * 阿里云发送短信策略
 */
public class AliyunSendSmsStrategy implements SendSmsStrategy{

    @Override
    public boolean send(Map<String, Object> param, String phone) {

        // 工具类获取值
        String aliyunAccessKeyId = AliyunPropertiesUtils.ALIYUN_ACCESS_KEYID;
        String aliyunAccessKeySecret = AliyunPropertiesUtils.ALIYUN_ACCESS_KEYSECRET;
        String SignName = AliyunPropertiesUtils.SIGN_NAME;
        String smsCode = AliyunPropertiesUtils.SMS_CODE;

        DefaultProfile profile =
                DefaultProfile.getProfile("default", aliyunAccessKeyId, aliyunAccessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);


        //设置相关固定的参数
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");

        //设置发送相关的参数
        request.putQueryParameter("PhoneNumbers",phone);
        //申请阿里云 签名名称
        request.putQueryParameter("SignName",SignName);
        //申请阿里云 模板code
        request.putQueryParameter("TemplateCode",smsCode);
        //验证码数据，转换json数据传递
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(param));

        try {
            //最终发送
            CommonResponse response = client.getCommonResponse(request);
            boolean success = response.getHttpResponse().isSuccess();
            return success;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
