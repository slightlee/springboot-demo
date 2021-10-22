package com.slightlee.sms.controller;

import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.slightlee.sms.service.SmsService;
import com.slightlee.sms.util.RandomUtil;
import com.slightlee.sms.util.Result;
import com.slightlee.sms.util.ResultEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(value = "发送短信接口", tags = "发送短信" )
@ApiSupport(order = 10,author = "明天")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SmsController {

    private final SmsService smsService;

    @ApiOperation(value = "发送短信")
    @GetMapping("sendMsm")
    public Result sendMsm(@ApiParam(value = "手机号") @RequestParam String phone) {
        String code = RandomUtil.getSixBitRandom();
        Map<String, Object> param = new HashMap<>(1);
        param.put("code", code);
        return smsService.send(param, phone) ? Result.success() : Result.success(ResultEnum.SEND_FAIL);
    }

}