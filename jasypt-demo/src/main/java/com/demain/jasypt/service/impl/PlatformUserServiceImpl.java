package com.demain.jasypt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demain.jasypt.entity.PlatformUser;
import com.demain.jasypt.mapper.PlatformUserMapper;
import com.demain.jasypt.service.PlatformUserService;
import org.springframework.stereotype.Service;

@Service
public class PlatformUserServiceImpl extends ServiceImpl<PlatformUserMapper, PlatformUser> implements PlatformUserService {

}
