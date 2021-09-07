package com.slightlee.knife4j.controller;


import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.slightlee.knife4j.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "测试接口2", tags = "测试2" )
@ApiSupport(order = 20,author = "明天")
@RestController
public class Test2Controller {

    @ApiOperation(value = "测试接口4")
    @ApiOperationSupport(order = 1,author = "明天1")
    @RequestMapping(value = "/list4",method = RequestMethod.GET)
    public Result<String> list4(){

        return Result.success("hello1");

    }


    @ApiOperation(value = "测试接口3")
    @ApiOperationSupport(order = 2,author = "明天2")
    @RequestMapping(value = "/list3",method = RequestMethod.GET)
    public Result<String> list3(){

        return Result.success("hello");

    }

}
