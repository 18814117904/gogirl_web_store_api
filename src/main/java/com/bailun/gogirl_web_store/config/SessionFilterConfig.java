package com.bailun.gogirl_web_store.config;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bailun.gogirl_web_store.filter.OriginFilter;


//@Configuration
//public class SessionFilterConfig {
//    @Bean
//    public FilterRegistrationBean<Filter> someFilterRegistration1() {
//        //新建过滤器注册类
//        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<Filter>();
//        // 添加我们写好的过滤器
////        registration.setFilter( new OriginFilter());
////        registration.setFilter( new SessionFilter());
//        // 设置过滤器的URL模式
//        registration.addUrlPatterns("/*");
//        return registration;
//    }
//
//}