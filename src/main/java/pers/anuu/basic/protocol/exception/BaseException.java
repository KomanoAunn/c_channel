package pers.anuu.basic.protocol.exception;

import lombok.Data;

/**
 * 异常基类
 *
 * @author 洪捃能
 * @data 2019/4/28
 */
@Data
public class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }
}
