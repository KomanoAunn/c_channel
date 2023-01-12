package pers.anuu.biz.user.model.params;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author pangxiong
 * @title: UserRegisterParams
 * @projectName c_channel
 * @description: TODO
 * @date 2022/12/616:00
 */
@Data
public class UserRegisterParams {

    @NotNull(message = "用户名不能为空")
    private String loginCode;
    @NotNull(message = "密码不能为空")
    private String password;
    @NotNull(message = "昵称不能为空")
    private String nickname;
}
