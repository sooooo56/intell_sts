package com.example.basic.domain.auth.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilterConfig {

    @Bean
    public FilterRegistrationBean<TestFilter> testFilterRegistrationBean() {
        FilterRegistrationBean<TestFilter> registrationBean = new FilterRegistrationBean<>(); // 필터 등록을 해주는 객체
        registrationBean.setFilter(new TestFilter()); // TestFilter를 등록하겠다.
        registrationBean.addUrlPatterns("/**"); // 모든 url

        return registrationBean;
    }

    // 관리자 권한 체크(adminFilter)
    @Bean
    public FilterRegistrationBean<AdminFilter> adminFilterRegistrationBean() {
        FilterRegistrationBean<AdminFilter> registrationBean = new FilterRegistrationBean<>(); // 필터 등록을 해주는 객체

        // 필터 등록
        registrationBean.setFilter(new AdminFilter());

        // 필터가 적용될 URL 패턴 설정
        // 관리자 경로에만 적용하고 싶은 경우
        registrationBean.addUrlPatterns("/admin/*");

        return registrationBean;
    }

    // 로그인 체크 (LoginFilter)
    @Bean
    public FilterRegistrationBean<LoginFilter> LoginFilterRegistrationBean() {
        // 필터 등록을 해주는 객체
        FilterRegistrationBean<LoginFilter> registrationBean = new FilterRegistrationBean<>();

        // 필터 등록
        registrationBean.setFilter(new LoginFilter());

        // 필터가 적용될 URL 패턴 설정
        registrationBean.addUrlPatterns("/article/write","/article/detail/*","/article/modify/*","/article/delete/*");

        return registrationBean;
    }


}