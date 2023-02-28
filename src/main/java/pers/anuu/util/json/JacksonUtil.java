package pers.anuu.util.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import pers.anuu.basic.protocol.exception.BaseException;

/**
 * @author pangxiong
 * @title: JacksonUtil
 * @projectName c_channel
 * @description: TODO
 * @date 2023/2/2311:21
 */
public class JacksonUtil {
    private static final ObjectMapper MAPPER = new ObjectMapper();


    public static JsonNode toJsonNode(String source) {
        try {
            return MAPPER.readTree(source);
        } catch (Exception e) {
            throw new BaseException(e.getMessage());
        }
    }
}
