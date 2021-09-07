package com.slightlee.knife4j.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.slightlee.knife4j.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Api(value = "测试接口", tags = "测试" )
@ApiSupport(order = 10)
@RestController
public class TestController {

    @ApiOperation(value = "测试接口1")
    @ApiOperationSupport(order = 1)
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Result<Page> list(){

        List<User> list = new ArrayList<>();

        User user = new User();
        user.setId(1);
        user.setName("张三");

        User user2 = new User();
        user2.setId(2);
        user2.setName("张三2");

        list.add(user);
        list.add(user2);
        Page page = new Page();
        page.setList(list);
        return Result.success(page);

    }

    @ApiOperation(value = "测试接口2")
    @ApiOperationSupport(order = 2)
    @RequestMapping(value = "/list2",method = RequestMethod.GET)
    public Result<Page> list2(){

        List<User> list = new ArrayList<>();

        User user = new User();
        user.setId(1);
        user.setName("张三");

        User user2 = new User();
        user2.setId(2);
        user2.setName("张三2");

        list.add(user);
        list.add(user2);
        Page page = new Page();
        page.setList(list);
        return Result.success(page);

    }





    class Page implements Serializable{
        private List<User> list;

        public List<User> getList() {
            return list;
        }

        public void setList(List<User> list) {
            this.list = list;
        }
    }

    @Data
    class User implements Serializable {

        private int id;

        private String name;

    }

}
