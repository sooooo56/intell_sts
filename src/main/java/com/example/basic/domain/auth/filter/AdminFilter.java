package com.example.basic.domain.auth.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

// @Component => 서블릿과 스프링은 관리 주체가 다르므로 구분해서 사용해야 한다
// 서블릿과 스프링에 같이 사용하게 되면 충돌이 날 수 있다.
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    // 오버라이드는 매개변수 변경 불가
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        // 세션에서 loginUser와 role 속성 가져오기
        String username = (String) session.getAttribute("loginUser");
        // normal, admin
        String role = (String) session.getAttribute("role");

        // 사용자 정보가 없거나 역할이 없는 경우 예외 발생
        if (username == null) {
            throw new RuntimeException("관리자 계정으로 로그인 해야만 사용 가능합니다.");
        }

        // role이 admin이 아닌 경우 예외 발생
        if (!role.equals("admin")) {
            throw new RuntimeException("관리자 권한만 접근 가능합니다.");
        }

        // 모든 검사를 통과하면 다음 필터로 요청을 넘김
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
