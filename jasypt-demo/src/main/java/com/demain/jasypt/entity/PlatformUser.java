package com.demain.jasypt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
public class PlatformUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long tenantId;

    private String account;

    private String password;

    private String nickname;

    private String realName;

    private String gender;

    private String email;

    private String phone;

    private Integer status;

    private String avatar;

    private String remark;

    private Long creator;

    private LocalDateTime createTime;

    private Long operator;

    private LocalDateTime updateTime;

    private Integer isDelete;


}
