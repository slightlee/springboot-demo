# 项目说明

> 注意版本！
>
> 使用jasypt实现对配置文件加密


### 1、引入jar包

```pom
<!-- jasypt 加密 -->
<dependency>
    <groupId>com.github.ulisesbocchio</groupId>
    <artifactId>jasypt-spring-boot-starter</artifactId>
    <version>3.0.4</version>
</dependency>

```

### 2、工具类

> 工具类调用的不同的方法来实现加密数据

```java
package com.demain.jasypt.util;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEByteEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

/**
 * Jasypt 加密类工具包
 */
public class JasyptUtils {

    private static final String PBEWITHMD5ANDDES = StandardPBEByteEncryptor.DEFAULT_ALGORITHM;

    private static final String PBEWITHHMACSHA512ANDAES_256 = "PBEWITHHMACSHA512ANDAES_256";


    /**
     * Jasypt加密
     * 加密方式 PBEWITHMD5ANDDES
     * @param password 加密秘钥
     * @param value    待加密值
     * @return 加密结果
     */
    public static String encryptPwdWithMd5(String password, String value) {
        // 创建加解密工具实例
        PooledPBEStringEncryptor encryptOr = new PooledPBEStringEncryptor();

        encryptOr.setConfig(cryptOr(password, PBEWITHMD5ANDDES));
        return encryptOr.encrypt(value);
    }

    /**
     * Jasypt解密
     * 加密方式 PBEWITHMD5ANDDES
     * @param password 加密秘钥
     * @param value    待解密密文
     * @return 解密结果
     */
    public static String decyptPwdWithMd5(String password, String value) {
        PooledPBEStringEncryptor encryptOr = new PooledPBEStringEncryptor();
        encryptOr.setConfig(cryptOr(password, PBEWITHMD5ANDDES));
        return encryptOr.decrypt(value);
    }

    /**
     * Jasypt加密
     * 加密方式 PBEWITHHMACSHA512ANDAES_256
     * @param password 加密秘钥
     * @param value    待加密密文
     * @Return:
     */
    public static String encryptPwdWithSha512(String password, String value) {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setConfig(cryptOr(password, PBEWITHHMACSHA512ANDAES_256));
        return encryptor.encrypt(value);
    }

    /**
     * Jasypt解密
     * 加密方式 PBEWITHHMACSHA512ANDAES_256
     * @param password 加密秘钥
     * @param value    待解密密文
     * @Return:
     */
    public static String decyptPwdWithSha512(String password, String value) {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setConfig(cryptOr(password, PBEWITHHMACSHA512ANDAES_256));
        return encryptor.decrypt(value);
    }


    /**
     * @Param: password 加密秘钥
     * @Param: algorithm 加密方式
     * @Return:
     */
    public static SimpleStringPBEConfig cryptOr(String password, String algorithm) {
        // 加解密配置
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(password);
        config.setAlgorithm(algorithm);
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName(null);
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        return config;
    }


    public static void main(String[] args) {

        System.out.println("-----采用MD5加密----");
        // 加密  PfuRBivbwOXrZlk2ZLNk/lWNjQJjXndQ
        System.out.println(encryptPwdWithMd5("ABCDEF", "123456"));
        System.out.println(encryptPwdWithMd5("ABCDEF", "root"));
        // 解密 123456
        System.out.println(decyptPwdWithMd5("ABCDEF", "PfuRBivbwOXrZlk2ZLNk/lWNjQJjXndQ"));

        System.out.println("-----采用SHA512加密----");

        // 加密  JqcfY6ZE6ah42VuphgL803bh1c0uW84Me1VDXdqg/yITQykgu9idqAzsWwp0l+jn
        System.out.println(encryptPwdWithSha512("ABCDEF", "123456"));
        System.out.println(encryptPwdWithSha512("ABCDEF", "root"));
        // 解密 123456
        System.out.println(decyptPwdWithSha512("ABCDEF", "JqcfY6ZE6ah42VuphgL803bh1c0uW84Me1VDXdqg/yITQykgu9idqAzsWwp0l+jn"));

    }
}
```



### 3、使用方式

#### 3.1、使用配置文件方式

> application.yml 配置文件
>
> 弊端：加密秘钥在配置文件中显示

```yaml
server:
  port: 9661

spring:
  application:
    name: jasypt-demo

  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/platform-boot?serverTimezone=GMT%2B8
    #采用md5
#    username: ENC(CZi3Uf1rN/ha4GK0JrxhveevdW8qFE1U)
#    password: ENC(wczwoSURCoz9ib1AD0vUufPuE6U+7RG1)
    #采用sha512
    username: ENC(vjUi0pOOxpDhcroeYgG/vvOjCIqea+8spEugFoW68+EKtIQnK7sIdCzn5stmsEZp)
    password: ENC(JqcfY6ZE6ah42VuphgL803bh1c0uW84Me1VDXdqg/yITQykgu9idqAzsWwp0l+jn)
    hikari:
      connection-timeout: 60000
      validation-timeout: 3000
      idle-timeout: 60000
      login-timeout: 5
      max-lifetime: 60000
      maximum-pool-size: 10
      minimum-idle: 10
      read-only: false

# 配置文件加密key
jasypt:
  encryptor:
    password: ABCDEF
    #采用md5
  #  algorithm: PBEWithMD5AndDES
    #采用sha512
    algorithm: PBEWITHHMACSHA512ANDAES_256
    iv-generator-classname: org.jasypt.iv.RandomIvGenerator


mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  mapper-locations: classpath*:**/mapper/xml/*.xml

```

#### 3.2、启动命令方式

> 优点：存在服务器中除了管理运维人员 其它人看不到

```java
java -jar -Djasypt.encryptor.password=ABCDEF -Djasypt.encryptor.algorithm=PBEWITHHMACSHA512ANDAES_256 -Djasypt.encryptor.iv-generator-classname=org.jasypt.iv.RandomIvGenerator jasypt-demo-1.0-SNAPSHOT.jar
```

#### 3.3、服务器的环境变量

> 把密钥放在linux系统的环境变量中去，只有能拿到服务器访问权限的人，才有可能知道密钥在哪

```shell
# 配置profile文件
export JASYPT_PASSWORD = ABCDEF

# 生效 
source /etc/profile

# 运行java程序时
java -jar -Djasypt.encryptor.password=${JASYPT_PASSWORD} xxx.jar
```

#### 3.4、使用自定义的Encryptor来存放

> 存放在配置类里面

直接放在启动类里面

```java
@Bean("jasyptStringEncryptor")
public StringEncryptor stringEncryptor(){
    PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
    SimpleStringPBEConfig config = new SimpleStringPBEConfig();
    config.setPassword("ABCDEF");
    config.setKeyObtentionIterations("1000");
    config.setPoolSize("1");
    config.setProviderName(null);
    // config.setAlgorithm("PBEWithMD5AndDES");
    config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
    config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
    config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
    config.setStringOutputType("base64");
    encryptor.setConfig(config);
    return encryptor;
}
```

或者 创建单独配置文件

```java
@Configuration
public class JasyptConfig {

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor(){
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("ABCDEF");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName(null);
        config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }
}
```

