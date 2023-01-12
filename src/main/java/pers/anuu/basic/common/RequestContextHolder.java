package pers.anuu.basic.common;

/**
 * @author pangxiong
 * @title: RequestContextHolder
 * @projectName c_channel
 * @description: TODO
 * @date 2022/12/1418:06
 */
public class RequestContextHolder {

    public static final ThreadLocal<RequestContextBean> requestContext = new ThreadLocal<RequestContextBean>();

    public static Long getUserId() {
        if (requestContext.get() == null) {
            return null;
        }
        return requestContext.get().getUserId();
    }

    public static void setInfo(Long userId, String ip) {
        RequestContextBean bean = RequestContextBean
                .builder()
                .userId(userId)
                .ip(ip)
                .build();
        requestContext.set(bean);
    }
}
