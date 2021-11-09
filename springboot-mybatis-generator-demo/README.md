

## mybatis  generator 代码生成

### 1、mybatis jar包

```xml
 <dependency>
     <groupId>org.mybatis.spring.boot</groupId>
     <artifactId>mybatis-spring-boot-starter</artifactId>
     <version>2.2.0</version>
</dependency>
```



### 2、添加插件

```xml
 <plugin>
   <groupId>org.mybatis.generator</groupId>
   <artifactId>mybatis-generator-maven-plugin</artifactId>
   <version>1.3.6</version>
   <configuration>
     <configurationFile>${basedir}/src/main/resources/generatorConfig.xml
     </configurationFile>
     <overwrite>true</overwrite>
     <verbose>true</verbose>
   </configuration>
</plugin>
```



### 3、generatorConfig.xml 文件  

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<generatorConfiguration>
    <!--    <properties resource="mybatis-generator/generator.properties"/>-->
    <!--    连接数据库jar包的路径-->
    <classPathEntry location="/Users/ming/local/repo/mysql/mysql-connector-java/8.0.26/mysql-connector-java-8.0.26.jar"/>
    <context id="DB2Tables"  targetRuntime="MyBatis3">
        <commentGenerator>
            <property name="suppressDate" value="true"/>
            <!-- 是否去除自动生成的注释 true：是 ： false:否 -->
            <property name="suppressAllComments" value="true"/>
        </commentGenerator>

        <!--数据库连接参数 -->
        <jdbcConnection
                driverClass="com.mysql.cj.jdbc.Driver"
                connectionURL="jdbc:mysql://127.0.0.1:3306/cloud-demo"
                userId="root"
                password="123456">
            <!--设置为 true 可以获取 tables 信息, 解决生成文件缺少 xxxByPrimaryKey 的问题 -->
            <property name="useInformationSchema" value="true"/>
        </jdbcConnection>

        <javaTypeResolver>
            <property name="forceBigDecimals" value="false"/>
        </javaTypeResolver>

        <!-- 实体类的包名和存放路径 -->
        <javaModelGenerator targetPackage="com.slightlee.entity" targetProject="src/main/java">
            <property name="enableSubPackages" value="true"/>
            <property name="trimStrings" value="true"/>
        </javaModelGenerator>

        <!-- 生成映射文件*.xml的位置-->
        <sqlMapGenerator targetPackage="mapper" targetProject="src/main/resources">
            <property name="enableSubPackages" value="true"/>
        </sqlMapGenerator>

        <!-- 生成DAO的包名和位置 -->
        <javaClientGenerator type="XMLMAPPER" targetPackage="com.slightlee.dao" targetProject="src/main/java">
            <property name="enableSubPackages" value="true"/>
        </javaClientGenerator>

        <!-- tableName：数据库中的表名或视图名；domainObjectName：生成的实体类的类名-->
        <table tableName="product" domainObjectName="Product"
               enableCountByExample="true"
               enableUpdateByExample="true"
               enableDeleteByExample="true"
               enableSelectByExample="true"
               selectByExampleQueryId="true"/>
        <!--
                <table tableName="xxx" domainObjectName="xxx"
                       enableCountByExample="false"
                       enableUpdateByExample="false"
                       enableDeleteByExample="false"
                       enableSelectByExample="false"
                       selectByExampleQueryId="false"/>
                ...
                <table tableName="xxx" domainObjectName="xxx"
                       enableCountByExample="false"
                       enableUpdateByExample="false"
                       enableDeleteByExample="false"
                       enableSelectByExample="false"
                       selectByExampleQueryId="false"/>
        -->
    </context>
</generatorConfiguration>


```

 

### 4、执行 mybatis-generator

> maven => plugins => mybatis-generator



### 5、单元测试

> 引入一些其它依赖
>
> 测试...