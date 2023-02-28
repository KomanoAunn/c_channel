package pers.anuu.basic.protocol.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pangxiong
 * @title: FilterConfiguration
 * @projectName c_channel
 * @description: TODO
 * @date 2023/2/2210:20
 */
@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean<RequestFilter> requestFilter() {
        return new FilterRegistrationBean<>(new RequestFilter());
    }
}
