package pers.anuu.base.service.impl;

import pers.anuu.base.model.AUser;
import pers.anuu.base.mapper.AUserMapper;
import pers.anuu.base.service.IAUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author anuu
 * @since 2022-12-07
 */
@Service
public class AUserServiceImpl extends ServiceImpl<AUserMapper, AUser> implements IAUserService {

}
