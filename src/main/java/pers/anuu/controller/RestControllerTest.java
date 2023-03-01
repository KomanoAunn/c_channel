package pers.anuu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.anuu.basic.model.BaseReq;
import pers.anuu.basic.model.BaseResp;

/**
 * @author pangxiong
 * @title: RestControllerTest
 * @projectName c_channel
 * @description: TODO
 * @date 2023/2/2118:08
 */
@Slf4j
@RestController
public class RestControllerTest {

    @RequestMapping("/test1")
    public BaseResp test1(BaseReq baseReq){
        log.info("BaseReq :{}",baseReq);
        return new BaseResp();
    }
}
