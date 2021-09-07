# 项目说明



## 1、什么是Actuator ？

> Actuator 是springboot程序的监控系统，可以实现健康检查，info信息等。在使用之前需要引入spring-boot-starter-actuator，并做简单的配置即可

## 2、引入依赖

```xml
<dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-actuator</artifactId>
 </dependency>
```

### 2.1 启动之后 访问 http://127.0.0.1:8601/actuator

```json
http://127.0.0.1:8601/actuator

{
  "_links": {
    "self": {
      "href": "http://127.0.0.1:8601/actuator",
      "templated": false
    },
    "health": {
      "href": "http://127.0.0.1:8601/actuator/health",
      "templated": false
    },
    "health-path": {
      "href": "http://127.0.0.1:8601/actuator/health/{*path}",
      "templated": true
    }
  }
}


http://127.0.0.1:8601/actuator/health

{
	"status": "UP"
}
```

## 3、yaml 文件配置

```yaml
management:
  endpoints:
    web:
      exposure:
        include: '*'  #默认值访问health,info端点  用*可以包含全部端点
  endpoint:
    health:
      show-details: always #获得健康检查中所有指标的详细信息
```

### 3.1、访问 http://127.0.0.1:8601/actuator 如下图：

```json

http://127.0.0.1:8601/actuator

{
  "_links": {
    "self": {
      "href": "http://127.0.0.1:8601/actuator",
      "templated": false
    },
    "beans": {
      "href": "http://127.0.0.1:8601/actuator/beans",
      "templated": false
    },
    "caches-cache": {
      "href": "http://127.0.0.1:8601/actuator/caches/{cache}",
      "templated": true
    },
    "caches": {
      "href": "http://127.0.0.1:8601/actuator/caches",
      "templated": false
    },
    "health-path": {
      "href": "http://127.0.0.1:8601/actuator/health/{*path}",
      "templated": true
    },
    "health": {
      "href": "http://127.0.0.1:8601/actuator/health",
      "templated": false
    },
    "info": {
      "href": "http://127.0.0.1:8601/actuator/info",
      "templated": false
    },
    "conditions": {
      "href": "http://127.0.0.1:8601/actuator/conditions",
      "templated": false
    },
    "configprops": {
      "href": "http://127.0.0.1:8601/actuator/configprops",
      "templated": false
    },
    "configprops-prefix": {
      "href": "http://127.0.0.1:8601/actuator/configprops/{prefix}",
      "templated": true
    },
    "env": {
      "href": "http://127.0.0.1:8601/actuator/env",
      "templated": false
    },
    "env-toMatch": {
      "href": "http://127.0.0.1:8601/actuator/env/{toMatch}",
      "templated": true
    },
    "loggers": {
      "href": "http://127.0.0.1:8601/actuator/loggers",
      "templated": false
    },
    "loggers-name": {
      "href": "http://127.0.0.1:8601/actuator/loggers/{name}",
      "templated": true
    },
    "heapdump": {
      "href": "http://127.0.0.1:8601/actuator/heapdump",
      "templated": false
    },
    "threaddump": {
      "href": "http://127.0.0.1:8601/actuator/threaddump",
      "templated": false
    },
    "metrics-requiredMetricName": {
      "href": "http://127.0.0.1:8601/actuator/metrics/{requiredMetricName}",
      "templated": true
    },
    "metrics": {
      "href": "http://127.0.0.1:8601/actuator/metrics",
      "templated": false
    },
    "scheduledtasks": {
      "href": "http://127.0.0.1:8601/actuator/scheduledtasks",
      "templated": false
    },
    "mappings": {
      "href": "http://127.0.0.1:8601/actuator/mappings",
      "templated": false
    }
  }
}


http://127.0.0.1:8601/actuator/health

{
  "status": "UP",
  "components": {
    "diskSpace": {
      "status": "UP",
      "details": {
        "total": 500100493312,
        "free": 438151622656,
        "threshold": 10485760,
        "exists": true
      }
    },
    "ping": {
      "status": "UP"
    }
  }
}
```



### 3.2  常用端点

> http://127.0.0.1:8601/actuator
>
> http://127.0.0.1:8601/actuator/health
>
> http://127.0.0.1:8601/actuator/info
>
> http://127.0.0.1:8601/actuator/beans
>
> http://127.0.0.1:8601/actuator/mappings
>
> http://127.0.0.1:8601/actuator/loggers
>
> http://127.0.0.1:8601/actuator/metrics
>
> http://127.0.0.1:8601/actuator/metrics
>
> http://127.0.0.1:8601/actuator/metrics/jvm.buffer.count

### 3.3 其它端点

| ID               | Description                                                  |
| ---------------- | ------------------------------------------------------------ |
| auditevents      | 显示当前应用程序的审计事件信息，需要 AuditEventRepository bean. |
| beans            | 展示你应用程序中Spring Beans的完整列表                       |
| caches           | 显示可用缓存信息                                             |
| conditions       | 显示自动装配类的状态及是否匹配                               |
| configprops      | 显示所有@ConfigurationProperties列表                         |
| env              | 显示ConfigurableEnvironment中的属性                          |
| flyway           | 显示Flyway数据库迁移信息，需要一个或多个 Flyway beans        |
| health           | 显示应用的健康信息（未认证只显示status，认证显示全部信息详情） |
| httptrace        | 显示HTTP跟踪信息（默认显示最后100个HTTP请求 - 响应交换），需要一个 HttpTraceRepository bean. |
| info             | 显示任意的应用信息                                           |
| integrationgraph | 显示Spring Integration图，需要 spring-integration-core依赖   |
| loggers          | 显示和修改应用程序中日志记录器的配置。                       |
| liquibase        | 展示Liquibase 数据库迁移，需要一个或多个 Liquibase beans.    |
| metrics          | 展示当前应用的 metrics 信息                                  |
| mappings         | 显示所有@RequestMapping 路径集列表                           |
| scheduledtasks   | 显示应用程序中的计划任务                                     |
| sessions         | 允许从Spring会话支持的会话存储中检索和删除用户会话。 需要一个 Servlet-based web application using Spring Session. |
| shutdown         | 允许应用以优雅的方式关闭（默认情况下不启用）                 |
| startup          | 显示由ApplicationStartup收集的启动步骤. 将 SpringApplication 配置为BufferingApplicationStartup. |
| threaddump       | 执行一个线程dump                                             |

