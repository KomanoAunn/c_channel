package pers.anuu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pers.anuu.biz.user.model.params.UserLoginParams;
import pers.anuu.biz.user.model.params.UserRegisterParams;
import pers.anuu.biz.user.service.UserLoginService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author pangxiong
 * @title: UserController
 * @projectName c_channel
 * @description: TODO
 * @date 2022/12/518:10
 */
@CrossOrigin
@RestController
public class UserController extends BaseController {
    @Resource
    private UserLoginService userLoginService;

    @ResponseBody
    @RequestMapping("/login")
    public String login(Model model, HttpServletRequest request, UserLoginParams params) {

        String token = userLoginService.login(params.getLoginCode(), params.getPassword());
        request.getSession().setAttribute("token", token);
        return "";
    }

    @ResponseBody
    @RequestMapping("/register")
    public void register(UserRegisterParams params) {
        userLoginService.register(params);
    }
}
