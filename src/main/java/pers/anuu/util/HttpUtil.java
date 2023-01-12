package pers.anuu.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author pangxiong
 * @title: HttpUtil
 * @projectName c_channel
 * @description: TODO
 * @date 2022/12/614:34
 */
public class HttpUtil {

    public static String getRemoteIP(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (!isEffectiveRemoteAddr(ip)) {
            if (!isEffectiveRemoteAddr(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }

            if (!isEffectiveRemoteAddr(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }

            if (!isEffectiveRemoteAddr(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }

            if (!isEffectiveRemoteAddr(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }

            if (!isEffectiveRemoteAddr(ip)) {
                ip = request.getRemoteAddr();
            }
        } else if (ip != null && ip.length() > 15) {
            String[] ips = ip.split(",");

            for(int index = 0; index < ips.length; ++index) {
                String strIp = ips[index];
                if (!"unknown".equalsIgnoreCase(strIp)) {
                    ip = strIp;
                    break;
                }
            }
        }

        return ip;
    }

    private static boolean isEffectiveRemoteAddr(final String remoteAddr) {
        return remoteAddr != null && !"".equals(remoteAddr.trim()) && !"unknown".equalsIgnoreCase(remoteAddr.trim());
    }
}
