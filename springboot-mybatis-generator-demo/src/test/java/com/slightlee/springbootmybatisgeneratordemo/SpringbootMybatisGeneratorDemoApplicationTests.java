package com.slightlee.springbootmybatisgeneratordemo;

import com.slightlee.dao.ProductMapper;
import com.slightlee.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.slightlee")
@Slf4j
class SpringbootMybatisGeneratorDemoApplicationTests {

    @Autowired
    private ProductMapper productMapper;

    @Test
    void contextLoads() {
    }



    @Test
    void testMybatisDemo() {
        Product product = productMapper.selectByPrimaryKey(1L);
        log.info("信息：{} ", product.toString());

    }
}
