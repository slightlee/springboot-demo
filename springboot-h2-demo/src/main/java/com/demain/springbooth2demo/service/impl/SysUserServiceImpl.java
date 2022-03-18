package com.demain.springbooth2demo.service.impl;

import com.demain.springbooth2demo.entity.SysUser;
import com.demain.springbooth2demo.mapper.SysUserMapper;
import com.demain.springbooth2demo.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author 明天
 * @since 2022-03-18
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public List<SysUser> list2() {
        return this.baseMapper.list2();
    }
}
