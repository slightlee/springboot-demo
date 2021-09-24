package com.slightlee.email.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
  * 服务接口
  * @Author Morrow
  * @Date 2021/9/24 16:46
  */
@RestController
public class MailController {

    @RequestMapping("register/{id}")
    public String register(@PathVariable int id){
        return "激活成功" + id;
    }
}
