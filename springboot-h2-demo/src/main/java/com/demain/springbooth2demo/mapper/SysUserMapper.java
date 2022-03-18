package com.demain.springbooth2demo.mapper;

import com.demain.springbooth2demo.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 用户信息 Mapper 接口
 * </p>
 *
 * @author 明天
 * @since 2022-03-18
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {


    List<SysUser> list2();
}
