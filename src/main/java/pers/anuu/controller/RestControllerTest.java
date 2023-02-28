package pers.anuu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.anuu.basic.model.BaseReq;
import pers.anuu.basic.model.BaseResp;

/**
 * @author pangxiong
 * @title: RestControllerTest
 * @projectName c_channel
 * @description: 参考doris-api的filter，请求处理 TODO
 * @date 2023/2/2118:08
 */
@RestController
public class RestControllerTest {

    @RequestMapping("/test1")
    public BaseResp test1(BaseReq baseReq){
        return new BaseResp();
    }
}
