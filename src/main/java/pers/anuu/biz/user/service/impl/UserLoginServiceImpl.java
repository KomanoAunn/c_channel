package pers.anuu.biz.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import pers.anuu.base.model.AUser;
import pers.anuu.base.service.IAUserService;
import pers.anuu.basic.cache.LocalCache;
import pers.anuu.basic.protocol.exception.BaseException;
import pers.anuu.biz.user.model.params.UserRegisterParams;
import pers.anuu.biz.user.model.po.AUserPO;
import pers.anuu.biz.user.service.UserLoginService;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author pangxiong
 * @title: UserLoginServiceImpl
 * @projectName c_channel
 * @description: TODO
 * @date 2022/12/614:52
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Resource
    private IAUserService userService;

    @Override
    public void register(UserRegisterParams userRegisterParams) {
        QueryWrapper<AUser> countQuery = new QueryWrapper<AUser>()
                .eq(AUser.LOGIN_CODE, userRegisterParams.getLoginCode())
                .eq(AUser.IS_DELETE, 0);
        if (userService.count(countQuery) > 0) {
            throw new BaseException("请不要重复注册");
        }
        //TODO 密码加密
        AUser user = new AUserPO(userRegisterParams);
        userService.save(user);
    }

    @Override
    public String login(String loginCode, String password) {
        AUser user = userService.getOne(new QueryWrapper<AUser>()
                .eq(AUser.IS_DELETE, 0)
                .eq(AUser.LOGIN_CODE, loginCode)
                .eq(AUser.PASSWORD, password));
        if (user == null) {
            throw new BaseException("用户不存在或密码不正确");
        }
        AUser updateUser = new AUser();
        updateUser.setId(user.getId());
        updateUser.setLastLoginTime(new Date());
        userService.updateById(updateUser);
        return this.createToken(user.getId());
    }

    @Override
    public Long getUserIdByToken(String token) {
        String value = LocalCache.getStringValue(token);
        return value != null ? Long.parseLong(value) : null;
    }

    private String createToken(Long userId) {
        long expireTime = System.currentTimeMillis() + 3600 * 1000;
        String token = DigestUtils.md5DigestAsHex(String.format("c-%s-%s", userId, expireTime).getBytes());
        LocalCache.put(token, userId, expireTime);
        return token;
    }
}
