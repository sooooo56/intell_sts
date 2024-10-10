package com.example.basic;

import com.example.basic.article.dao.ArticleDao;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final ArticleDao articleDao;

    @RequestMapping("/test/html")
    public String showHtml() {
        return "test/test"; // .html 확장자를 스프링부트가 자동으로 붙여줌
    }

    @RequestMapping("/test/fruits")
    public String fruits() {
        return "test/fruits";
    }

    @RequestMapping("/test/va")
    public String variable() {
        return "test/variable";
    }

    @RequestMapping("/test/co")
    public String condition() {
        return "test/condition";
    }

    @RequestMapping("/test/loop")
    public String loop() {
        return "test/loop";
    }

    // 쿠키 테스트
    @GetMapping("/find-cookie")
    @ResponseBody
    public String findCookie(HttpServletRequest request) {
        // 요청에서 쿠키 배열을 가져옴
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            // 모든 쿠키를 순회하여 이름이 "myCookie"인 쿠키를 찾음
            for (Cookie cookie : cookies) {
                if ("test".equals(cookie.getName())) {
                    return "Cookie value: " + cookie.getValue();
                }
            }
        }

        return "쿠키가 없습니다.";
    }


    @GetMapping("/cookie-test")
    @ResponseBody
    public String cookieTest(HttpServletResponse response) {
        Cookie cookie = new Cookie("test", "1234");

        // 쿠키의 유효 시간 설정 (초 단위, 1시간 유효)
        cookie.setMaxAge(60 * 60);

        // 쿠키의 경로 설정 (도메인의 어느 경로에서 쿠키가 유효한지)
        cookie.setPath("/");

        // 응답에 쿠키 추가
        response.addCookie(cookie);

        return "쿠키를 발행하였습니다.";
    }


}
