package pers.anuu.basic.common;

import lombok.Builder;
import lombok.Data;

/**
 * @author pangxiong
 * @title: RequestContextBean
 * @projectName c_channel
 * @description: TODO
 * @date 2022/12/1418:09
 */
@Data
@Builder
public class RequestContextBean {
    private Long userId;
    private String ip;
}
