package com.demain.jasypt.controller;


import com.demain.jasypt.entity.PlatformUser;
import com.demain.jasypt.service.PlatformUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class PlatformUserController {

    private final PlatformUserService platformUserService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<PlatformUser> list(){

        return platformUserService.list();
    }
}

