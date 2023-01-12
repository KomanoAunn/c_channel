package pers.anuu.basic.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pangxiong
 * @title: BaseResp
 * @projectName c_channel
 * @description: TODO
 * @date 2023/1/1215:52
 */
@Data
public class BaseResp {
    private Map<String,Object> data=new HashMap<>();

}
