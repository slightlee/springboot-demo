# 项目说明

简单集成 cannal demo示例

cannal 官方地址：https://github.com/alibaba/canal

## 简介



![img](https://camo.githubusercontent.com/63881e271f889d4a424c55cea2f9c2065f63494fecac58432eac415f6e47e959/68747470733a2f2f696d672d626c6f672e6373646e696d672e636e2f32303139313130343130313733353934372e706e67)

> **canal [kə'næl]**，译意为水道/管道/沟渠，主要用途是基于 `MySQL 数据库增量日志解析，提供增量数据订阅和消费`
>
> 早期阿里巴巴因为杭州和美国双机房部署，存在跨机房同步的业务需求，实现方式主要是基于业务 trigger 获取增量变更。从 2010 年开始，业务逐步尝试数据库日志解析获取增量变更进行同步，由此衍生出了大量的数据库增量订阅和消费业务。
>
> 基于日志增量订阅和消费的业务包括
>
> - 数据库镜像
> - 数据库实时备份
> - 索引构建和实时维护(拆分异构索引、倒排索引等)
> - 业务 cache 刷新
> - 带业务逻辑的增量数据处理
>
> 当前的 canal 支持源端 MySQL 版本包括 5.1.x , 5.5.x , 5.6.x , 5.7.x , 8.0.x

> 工作原理

## MySQL主备复制原理

> MySQL master 将数据变更写入二进制日志( binary log, 其中记录叫做二进制日志事件binary log events，可以通过 show binlog events 进行查看)
> MySQL slave 将 master 的 binary log events 拷贝到它的中继日志(relay log)
> MySQL slave 重放 relay log 中事件，将数据变更反映它自己的数据

## canal 工作原理

> canal 模拟 MySQL slave 的交互协议，伪装自己为 MySQL slave ，向 MySQL master 发送dump 协议
> MySQL master 收到 dump 请求，开始推送 binary log 给 slave (即 canal )
> canal 解析 binary log 对象(原始为 byte 流)

## 简单步骤

> 1、开启 开启 Binlog 写入功能
>
> ```sql
>常用命令：
> 
>  -- MYSQL是否已经开启BINLOG
> show variables like 'log_bin';
> 
> -- 查看binlog模式
> show variables like 'binlog_format%';
> 
> -- 查看binlog日志文件列表
> 
> show binary logs;
> 
> -- 查看当前正在写入的binlog文件
> 
> show master status;
> ```
> 
> 2、配置修改 （canal.deployer-1.1.5\conf\example 配置文件）
>
> 3、启动 canal.deployer
>
> 4、启动本项目

## 拓展

> canal.deployer-1.1.5\conf\example 配置文件
>
> 下载地址 https://github.com/alibaba/canal/releases/tag/canal-1.1.5

> canal.deployer-1.1.5\conf\example 配置文件
>
> ```properties
> #################################################
> ## mysql serverId , v1.0.26+ will autoGen
> # canal.instance.mysql.slaveId=0
> 
> # enable gtid use true/false
> canal.instance.gtidon=false
> 
> # position info
> canal.instance.master.address=127.0.0.1:3306
> #binlog日志名称
> canal.instance.master.journal.name=DESKTOP-3NSN6AG-bin.000076
> #mysql主库链接时起始的binlog偏移量
> canal.instance.master.position=5224
> #mysql主库链接时起始的binlog的时间戳
> canal.instance.master.timestamp=
> canal.instance.master.gtid=
> 
> # rds oss binlog
> canal.instance.rds.accesskey=
> canal.instance.rds.secretkey=
> canal.instance.rds.instanceId=
> 
> # table meta tsdb info
> canal.instance.tsdb.enable=true
> #canal.instance.tsdb.url=jdbc:mysql://127.0.0.1:3306/canal_tsdb
> #canal.instance.tsdb.dbUsername=canal
> #canal.instance.tsdb.dbPassword=canal
> 
> #canal.instance.standby.address =
> #canal.instance.standby.journal.name =
> #canal.instance.standby.position =
> #canal.instance.standby.timestamp =
> #canal.instance.standby.gtid=
> 
> # username/password
> canal.instance.dbUsername=root	
> canal.instance.dbPassword=123456
> canal.instance.connectionCharset = UTF-8
> # enable druid Decrypt database password
> canal.instance.enableDruid=false
> #canal.instance.pwdPublicKey=MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALK4BUxdDltRRE5/zXpVEVPUgunvscYFtEip3pmLlhrWpacX7y7GCMo2/JM6LeHmiiNdH1FWgGCpUfircSwlWKUCAwEAAQ==
> 
> # table regex
> canal.instance.filter.regex=.*\\..*
> # table black regex
> canal.instance.filter.black.regex=mysql\\.slave_.*
> #canal.instance.filter.black.regex=
> # table field filter(format: schema1.tableName1:field1/field2,schema2.tableName2:field1/field2)
> #canal.instance.filter.field=test1.t_product:id/subject/keywords,test2.t_company:id/name/contact/ch
> # table field black filter(format: schema1.tableName1:field1/field2,schema2.tableName2:field1/field2)
> #canal.instance.filter.black.field=test1.t_product:subject/product_image,test2.t_company:id/name/contact/ch
> 
> # mq config
> canal.mq.topic=example
> # dynamic topic route by schema or table regex
> #canal.mq.dynamicTopic=mytest1.user,mytest2\\..*,.*\\..*
> canal.mq.partition=0
> # hash partition config
> #canal.mq.partitionsNum=3
> #canal.mq.partitionHash=test.table:id^name,.*\\..*
> #canal.mq.dynamicTopicPartitionNum=test.*:4,mycanal:6
> #################################################
> ```

## 参考资料：

https://github.com/alibaba/canal/wiki/ClientExample
https://blog.csdn.net/yehongzhi1994/article/details/107880162