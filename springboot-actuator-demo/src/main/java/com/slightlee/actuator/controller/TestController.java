package com.slightlee.actuator.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {


    @RequestMapping(value = "/getStr2",method = RequestMethod.GET)

    public String getStr2(){
        return "hello";
    }

    @RequestMapping(value = "/getList",method = RequestMethod.GET)
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
        private int id;
        private String name;
    }


}
