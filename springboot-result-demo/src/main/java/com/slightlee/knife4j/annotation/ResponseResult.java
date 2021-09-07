package com.slightlee.knife4j.annotation;

import java.lang.annotation.*;

/**
 * 自定义响应结果注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface ResponseResult {
}
