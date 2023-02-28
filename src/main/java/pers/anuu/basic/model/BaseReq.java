package pers.anuu.basic.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

/**
 * @author pangxiong
 * @title: BaseReq
 * @projectName c_channel
 * @description: TODO
 * @date 2023/2/2115:03
 */
@Data
public class BaseReq implements java.io.Serializable{
    private String content;

    private JsonNode jsonNode;
}
