DROP SCHEMA
    IF
    EXISTS `h2_demo`;
CREATE SCHEMA `h2_demo`;
USE `h2_demo`;
DROP TABLE
    IF
    EXISTS `sys_user`;
CREATE TABLE `sys_user` (
                            `user_id` VARCHAR ( 64 ) NOT NULL COMMENT '主键ID',
                            `username` VARCHAR ( 128 ) NOT NULL UNIQUE COMMENT '用户名',
                            `password` VARCHAR ( 1024 ) NOT NULL COMMENT '密码',
                            `expired` TINYINT ( 1 ) NOT NULL DEFAULT 1 COMMENT '账户是否过期',
                            `locked` TINYINT ( 1 ) NOT NULL DEFAULT 1 COMMENT '账户是否锁定',
                            `enabled` TINYINT ( 1 ) NOT NULL DEFAULT 1 COMMENT '账户是否可用',
                            PRIMARY KEY ( `user_id` )
) ENGINE = INNODB COMMENT '用户信息' DEFAULT CHARSET = utf8mb4;