package com.demain.springbooth2demo;

import com.demain.springbooth2demo.entity.SysUser;
import com.demain.springbooth2demo.service.ISysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootH2DemoApplicationTests {

    @Autowired
    private ISysUserService sysUserService;


    @Test
    void contextLoads() {
    }


    /**
     * 测试简单查询
     */
    @Test
    void testList() {

        List<SysUser> list = sysUserService.list2();
        list.forEach(sysUser -> System.out.println(sysUser.getUsername()));
    }

}
