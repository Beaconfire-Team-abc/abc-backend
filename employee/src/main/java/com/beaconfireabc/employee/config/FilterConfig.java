package com.beaconfireabc.employee.config;

import com.beaconfireabc.employee.security.filter.JWTFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<JWTFilter> jwtFilter() {
        final FilterRegistrationBean<JWTFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JWTFilter());
        registrationBean.setInitParameters(Collections.singletonMap("services.auth", "http://localhost:9999/auth/login"));
//        registrationBean.addUrlPatterns("/employee/*");
        return registrationBean;
    }
}
