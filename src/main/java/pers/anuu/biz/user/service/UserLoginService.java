package pers.anuu.biz.user.service;

import pers.anuu.biz.user.model.params.UserRegisterParams;

/**
 * @author pangxiong
 * @title: UserLoginService
 * @projectName c_channel
 * @description: TODO
 * @date 2022/12/614:50
 */
public interface UserLoginService {

    void register(UserRegisterParams userRegisterParams);

    String login(String loginCode,String password);

    Long getUserIdByToken(String token);
}
