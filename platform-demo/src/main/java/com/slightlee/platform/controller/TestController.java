package com.slightlee.platform.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.slightlee.platform.annotation.ResponseResult;
import com.slightlee.platform.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Api(value = "测试接口", tags = "测试" )
@ApiSupport(order = 30,author = "明天")
@RestController
@ResponseResult
public class TestController {


    @ApiOperation(value = "测试接口1")
    @ApiOperationSupport(order = 1,author = "明天")
    @RequestMapping(value = "/getStr2",method = RequestMethod.GET)

    public String getStr2(){
        return "hello";
    }

    @ApiOperation(value = "测试接口2")
    @ApiOperationSupport(order = 2)
    @RequestMapping(value = "/getList",method = RequestMethod.GET)
    @ResponseResult
    public List<User> getList(){

        List<User> list = new ArrayList<>();

        User user = new User();
        user.setId(1);
        user.setName("张三");

        User user2 = new User();
        user2.setId(2);
        user2.setName("张三2");

        list.add(user);
        list.add(user2);

        return list;

    }

    @Data
    class User implements Serializable {

        @ApiModelProperty(value = "ID")
        private int id;

        @ApiModelProperty(value = "用户名")
        private String name;
    }


}
