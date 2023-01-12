package pers.anuu.basic.protocol.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import pers.anuu.util.HttpUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 洪捃能
 * @data 2019/5/23 10:08
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandler {
    Logger apiLogger = LoggerFactory.getLogger("apiLogger");

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String handle(Exception exception) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.info("=================== Start ===================");
        // 打印请求 url
        String uri = request.getRequestURI();
        String ip = HttpUtil.getRemoteIP(request);
        log.info("API            : {} {}", request.getMethod(), uri);


        return "";
    }

}
