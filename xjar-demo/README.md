# 项目说明

> 基于 jasypt-demo 基础上进行加密
>
> 使用xjar实现对jar包进行加密
>
> 此demo目前只涉及加密
>
> 注：`运行环境说明：`  **window下 jdk 11**    **linux 下 jdk 8**   不同环境命令会有不同


### 1、引入jar包

```pom
<!-- 添加 XJar 依赖 -->
<dependency>
    <groupId>com.github.core-lib</groupId>
    <artifactId>xjar</artifactId>
    <version>4.0.2</version>
</dependency>
```

### 2、加密操作

> 加密打包后的jar包
>
> 执行加密源码方法
>
> **注意路径**

```java
package xjar.util;

import io.xjar.XCryptos;

/**
 * 测试jar是否加密成功
 */
public class TestJar {


    /**
     * 文件地址
     */
    private static final String IN_PATH = "D:\\Desktop\\code\\springboot-demo\\xjar-demo\\target\\xjar-demo-1.0-SNAPSHOT.jar";

    /**
     * 输出地址
     */
    private static final String OUT_PATH = "D:\\Desktop\\code\\springboot-demo\\xjar-demo\\target\\new-xjar-demo-1.0-SNAPSHOT.jar";

    /**
     * 加密秘钥
     */
    private static final String SECRET = "123456";


    /**
     * 加密jar
     */
    private static void hanlderEncryptionJar() throws Exception {
        XCryptos.encryption()
                .from(IN_PATH)
                .use(SECRET)
                .include("/**.class")
                .include("/**/*.xml")
                .to(OUT_PATH);
    }


    public static void main(String[] args) throws Exception {
        System.out.println("----- 准备开始加密------");
        hanlderEncryptionJar();
        System.out.println("----- 加密完成------");
    }

}

```

| 方法名称 | 参数列表                                                     | 是否必选                             | 方法说明                                        |
| -------- | ------------------------------------------------------------ | ------------------------------------ | ----------------------------------------------- |
| from     | (String jar)                                                 | 二选一                               | 指定待加密JAR包路径                             |
| from     | (File jar)                                                   | 指定待加密JAR包文件                  |                                                 |
| use      | (String password)                                            | 二选一                               | 指定加密密码                                    |
| use      | (String algorithm, int keysize, int ivsize, String password) | 指定加密算法及加密密码               |                                                 |
| include  | (String ant)                                                 | 可多次调用                           | 指定要加密的资源相对于classpath的ANT路径表达式  |
| include  | (Pattern regex)                                              | 可多次调用                           | 指定要加密的资源相对于classpath的正则路径表达式 |
| exclude  | (String ant)                                                 | 可多次调用                           | 指定不加密的资源相对于classpath的ANT路径表达式  |
| exclude  | (Pattern regex)                                              | 可多次调用                           | 指定不加密的资源相对于classpath的正则路径表达式 |
| to       | (String xJar)                                                | 二选一                               | 指定加密后JAR包输出路径, 并执行加密.            |
| to       | (File xJar)                                                  | 指定加密后JAR包输出文件, 并执行加密. |                                                 |

- 指定加密算法的时候密钥长度以及向量长度必须在算法可支持范围内, 具体加密算法的密钥及向量长度请自行百度或谷歌.
- include 和 exclude 同时使用时即加密在include的范围内且排除了exclude的资源.



> 加密之后生成的相关文件

![image-20220218100345707](https://gitee.com/Leagle/picture-bed/raw/master/20220218100345.png)

### 3、安装go环境

#### 3.1 window环境介绍

##### 3.1.1 下载 go 安装包

> 官方链接：https://go.dev/

点击下载选择 windows环境下的安装包

![image-20220218095816269](https://gitee.com/Leagle/picture-bed/raw/master/20220218095818.png)



##### 3.1.2 点击安装 

安装之后 查看版本号 `go version`

```shell
C:\Users\admin>go version
go version go1.17.7 windows/amd64
```

### 3.2 linux环境

##### 3.2.1 下载 linux 环境安装包

> 方式1: wget https://go.dev/dl/go1.17.7.linux-amd64.tar.gz 下载
>
> 方式2：本地下载上传到服务器

##### 3.2.2 解压

```shell
tar -xvf go1.17.7.linux-amd64.tar.gz 
```

##### 3.2.3 设置环境变量

```shell
vim /etc/profile   # 编辑配置
```

```shell
export GO_HOME=/usr/local/go
export PATH=$PATH:$GO_HOME/bin
```

```shell
[root@localhost go]# source /etc/profile   # 刷新配置
[root@localhost go]# go version
go version go1.17.7 linux/amd64
```

### 4、 编译脚本

```go
go build xjar.go
```

> 编译之后生成 xjar.exe 文件
>
> window环境: xjar.exe   linux环境：xjar

![image-20220218100711330](https://gitee.com/Leagle/picture-bed/raw/master/20220218100711.png)

### 5、执行启动

> JDK-9及以上版本 在启动时添加参数 --add-opens java.base/jdk.internal.loader=ALL-UNNAMED

#### windows:

```java
jdk11
    
xjar.exe java --add-opens java.base/jdk.internal.loader=ALL-UNNAMED -jar new-xjar-demo-1.0-SNAPSHOT.jar
```

#### linux：

```she
jdk8

[root@localhost xjar]# ./xjar java -jar new-xjar-demo-1.0-SNAPSHOT.jar 
```



### 6、拓展 

> 使用 JD-GUI 反编译 jar 包对比加密之前以及加密之后的文件
>
> 下载地址：http://java-decompiler.github.io/

##### JasyptConfig 加密之前

![image-20220218112522141](https://gitee.com/Leagle/picture-bed/raw/master/20220218112522.png)

##### JasyptConfig 加密之后

![image-20220218112549640](https://gitee.com/Leagle/picture-bed/raw/master/20220218112549.png)



### 注意事项：（官方）

#### 1. 不兼容 spring-boot-maven-plugin 的 executable = true 以及 embeddedLaunchScript

```
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <!-- 需要将executable和embeddedLaunchScript参数删除, 目前还不能支持对该模式Jar的加密！后面可能会支持该方式的打包. 
    <configuration>
        <executable>true</executable>
        <embeddedLaunchScript>...</embeddedLaunchScript>
    </configuration>
    -->
</plugin>
```

#### 2. Spring Boot + JPA(Hibernate) 启动报错问题

如果项目中使用了 JPA 且实现为Hibernate时, 由于Hibernate自己解析加密后的Jar文件, 所以无法正常启动, 可以采用以下解决方案:

1. clone [XJar-Agent-Hibernate](https://github.com/core-lib/xjar-agent-hibernate) , 使用 mvn clean package 编译出 xjar-agent-hibernate-${version}.jar 文件
2. 采用 xjar java -javaagent:xjar-agent-hibernate-${version}.jar -jar your-spring-boot-app.jar 命令启动

#### 3. 静态文件浏览器无法加载完成问题

> 由于静态文件被加密后文件体积变大, Spring Boot 会采用文件的大小作为 Content-Length 头返回给浏览器, 但实际上通过 XJar 加载解密后文件大小恢复了原本的大小, 所以浏览器认为还没接收完导致一直等待服务端. 由此我们需要在加密时忽略静态文件的加密, 实际上静态文件也没加密的必要, 因为即便加密了用户在浏览器 查看源代码也是能看到完整的源码.通常情况下静态文件都会放在 static/ 和 META-INF/resources/ 目录下, 我们只需要在加密时通过 exclude 方法排除这些资源即可, 可以参考以下例子：

```
XCryptos.encryption()
        .from("/path/to/read/plaintext.jar")
        .use("io.xjar")
        .exclude("/static/**/*")
        .exclude("/META-INF/resources/**/*")
        .to("/path/to/save/encrypted.jar");
```

#### 4. JDK-9及以上版本由于模块化导致XJar无法使用 jdk.internal.loader 包的问题解决方案

> 在启动时添加参数 --add-opens java.base/jdk.internal.loader=ALL-UNNAMED

```
xjar java --add-opens java.base/jdk.internal.loader=ALL-UNNAMED -jar /path/to/encrypted.jar
```

#### 5. 由于使用了阿里云Maven镜像导致无法从 jitpack.io 下载 XJar 依赖的问题

> 参考如下设置, 在镜像配置的 mirrorOf 元素中加入 ,!jitpack.io 结尾.

```
<mirror>
    <id>alimaven</id>
    <mirrorOf>central,!jitpack.io</mirrorOf>
    <name>aliyun maven</name>
    <url>http://maven.aliyun.com/nexus/content/repositories/central/</url>
</mirror>
```

### 参考：

> 更多其它操作可以参考官方文档 https://github.com/core-lib/xjar

