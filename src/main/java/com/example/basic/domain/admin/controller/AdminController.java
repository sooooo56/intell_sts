package com.example.basic.domain.admin.controller;

import com.example.basic.global.ReqResHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final ReqResHandler reqResHandler;

    // 관리자 페이지
    @GetMapping("/main")
    public String main(HttpServletRequest request, Model model, HttpSession session) {

        String username = (String)session.getAttribute("loginUser");

        if(username == null) {
            throw new RuntimeException("관리자 계정으로 로그인 해야만 사용 가능합니다.");
        }

        // normal, admin
        String role = (String)session.getAttribute("role");

        if(!role.equals("admin")) {
            throw new RuntimeException("관리자 권한만 접근 가능합니다.");
        }

        return "admin/main";
    }

    // 통계페이지
    @GetMapping("/stat")
    public String stat(HttpSession session) {

        String username = (String)session.getAttribute("loginUser");

        if(username == null) {
            throw new RuntimeException("관리자 계정으로 로그인 해야만 사용 가능합니다.");
        }

        // normal, admin
        String role = (String)session.getAttribute("role");

        if(!role.equals("admin")) {
            throw new RuntimeException("관리자 권한만 접근 가능합니다.");
        }

        return "admin/stat";
    }

    // 유저관리 페이지
    @GetMapping("/user")
    public String user(HttpSession session) {

        String username = (String)session.getAttribute("loginUser");

        if(username == null) {
            throw new RuntimeException("관리자 계정으로 로그인 해야만 사용 가능합니다.");
        }

        // normal, admin
        String role = (String)session.getAttribute("role");

        if(!role.equals("admin")) {
            throw new RuntimeException("관리자 권한만 접근 가능합니다.");
        }
        return "admin/user";
    }


}