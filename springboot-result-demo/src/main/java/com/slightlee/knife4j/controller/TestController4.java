package com.slightlee.knife4j.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.slightlee.knife4j.annotation.ResponseResult;
import com.slightlee.knife4j.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 自定义全局拦截 ResponseResultHandler
 */
@Api(value = "测试接口4", tags = "测试4" )
@ApiSupport(order = 30,author = "明天")
@RestController
@ResponseResult
public class TestController4 {


    @ApiOperation(value = "测试接口11")
    @ApiOperationSupport(order = 1,author = "明天1")
    @RequestMapping(value = "/getStr11",method = RequestMethod.GET)
    public Result<String> getStr11(){
        return Result.success("hello");
    }


}
