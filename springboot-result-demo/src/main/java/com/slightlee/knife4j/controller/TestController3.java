package com.slightlee.knife4j.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.slightlee.knife4j.Exception.PlatformException;
import com.slightlee.knife4j.annotation.ResponseResult;
import com.slightlee.knife4j.util.Result;
import com.slightlee.knife4j.util.ResultEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自定义全局拦截 ResponseResultHandler
 */
@Api(value = "测试接口3", tags = "测试3" )
@ApiSupport(order = 30,author = "明天")
@RestController
public class TestController3 {


    @ApiOperation(value = "测试接口11")
    @ApiOperationSupport(order = 1,author = "明天1")
    @RequestMapping(value = "/getStr1",method = RequestMethod.GET)
    public Result<String> getStr(){
        return Result.success("hello");
    }

    @ApiOperation(value = "测试接口12")
    @ApiOperationSupport(order = 2,author = "明天1")
    @RequestMapping(value = "/getStr2",method = RequestMethod.GET)
    @ResponseResult
    public String getStr2(){
        return "hello";
    }

    @ApiOperation(value = "测试接口13")
    @ApiOperationSupport(order = 3,author = "明天1")
    @RequestMapping(value = "/getStr3",method = RequestMethod.GET)
    public String getStr3(){
        return "hello";
    }



    @ApiOperation(value = "测试接口14")
    @ApiOperationSupport(order = 4)
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


    @ApiOperation(value = "测试接口15")
    @ApiOperationSupport(order = 5,author = "明天1")
    @RequestMapping(value = "/getMap",method = RequestMethod.GET)
    @ResponseResult
    public Map<String,Integer> getMap(){
        Map<String, Integer> map = new HashMap<>();
        map.put("zhangsan",1);
        return map;
    }

    @ApiOperation(value = "测试接口16")
    @ApiOperationSupport(order = 6,author = "明天1")
    @RequestMapping(value = "/getError",method = RequestMethod.GET)
    @ResponseResult
    public Integer getError(){
       int i = 1/0;
        return i;
    }

    @ApiOperation(value = "测试接口17")
    @ApiOperationSupport(order = 6,author = "明天1")
    @RequestMapping(value = "/getError2",method = RequestMethod.GET)
    @ResponseResult
    public Integer getError2(){
        int i = 0;
        try {
            i = 1/0;
        } catch (Exception e) {
            throw new PlatformException(ResultEnum.DIVIDED_IS_ERROR);
        }
        return i;
    }
}
