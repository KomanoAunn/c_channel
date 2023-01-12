package pers.anuu.biz.user.model.params;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author pangxiong
 * @title: UserLoginParams
 * @projectName c_channel
 * @description: TODO
 * @date 2022/12/715:27
 */
@Data
public class UserLoginParams {
    @NotNull(message = "用户名不能为空")
    private String loginCode;
    @NotNull(message = "密码不能为空")
    private String password;
}
