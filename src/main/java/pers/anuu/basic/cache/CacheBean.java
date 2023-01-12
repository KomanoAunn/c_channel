package pers.anuu.basic.cache;

import lombok.Data;

/**
 * @author pangxiong
 * @title: CacheBean
 * @projectName c_channel
 * @description: TODO
 * @date 2022/12/714:49
 */
@Data
public class CacheBean<T> {
    private Long expireTime;

    private T value;

    private Integer version;
}
