package pers.anuu.biz.user.model.po;

import pers.anuu.base.model.AUser;
import pers.anuu.biz.user.model.params.UserRegisterParams;

import java.util.Date;

/**
 * @author pangxiong
 * @title: AUserPO
 * @projectName c_channel
 * @description: TODO
 * @date 2022/12/617:43
 */
public class AUserPO extends AUser {

    public AUserPO(UserRegisterParams params) {
        this.setLoginCode(params.getLoginCode());
        //TODO 需要2次加密
        this.setPassword(params.getPassword());
        //this.setHeadImg();
        this.setNickname(params.getNickname());
        this.setUserStatus(true);
        this.setAddTime(new Date());
        this.setIsDelete(false);
    }
}
