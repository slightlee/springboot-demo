# 项目说明

> 启动之后 访问 127.0.0.1:8661/doc.html   
> 输入账号/密码 test/test
> 访问接口即可
>
> @ResponseResult 注解 可用在类以及方法上   
> 见下方源码
```java
// 判断是否在类对象上加了注解
if (clazz.isAnnotationPresent(ResponseResult.class)) {
    // 设置该请求返回体，需要包装，往下传递，在ResponseBodyAdvice接口进行判断
    request.setAttribute(RESPONSE_RESULT_ANNOTATION, clazz.getAnnotation(ResponseResult.class));
}
// 判断是否在方法上加了注解
else if (method.isAnnotationPresent(ResponseResult.class)) {
    // 设置该请求返回体，需要包装，往下传递，在ResponseBodyAdvice接口进行判断
    request.setAttribute(RESPONSE_RESULT_ANNOTATION, method.getAnnotation(ResponseResult.class));
}
```
>使用方法
```java
@ResponseResult
public class TestController4 {}

@ResponseResult
public String getStr2(){}
```