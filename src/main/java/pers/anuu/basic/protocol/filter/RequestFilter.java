package pers.anuu.basic.protocol.filter;

import org.springframework.web.filter.OncePerRequestFilter;
import pers.anuu.basic.common.UserRequestContextHolder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author pangxiong
 * @title: RequestFilter
 * @projectName c_channel
 * @description: TODO
 * @date 2023/2/2210:22
 */
public class RequestFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        ServletInputStream servletInputStream = httpServletRequest.getInputStream();
        byte[] buff = new byte[1024];
        servletInputStream.read(buff);
        String content = new String(buff, StandardCharsets.UTF_8).split("\0")[0];
        UserRequestContextHolder.setContent(content);
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
