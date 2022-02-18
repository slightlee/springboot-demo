package xjar.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xjar.entity.PlatformUser;
import xjar.mapper.PlatformUserMapper;
import xjar.service.PlatformUserService;

@Service
public class PlatformUserServiceImpl extends ServiceImpl<PlatformUserMapper, PlatformUser> implements PlatformUserService {

}
