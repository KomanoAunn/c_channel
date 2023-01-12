package pers.anuu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author pangxiong
 * @title: BaseController
 * @projectName b_channel
 * @description: TODO
 * @date 2022/10/1411:25
 */
@Controller
public class BaseController {

    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
}
