package com.demain.springbooth2demo.service;

import com.demain.springbooth2demo.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author 明天
 * @since 2022-03-18
 */
public interface ISysUserService extends IService<SysUser> {

    List<SysUser> list2();
}
