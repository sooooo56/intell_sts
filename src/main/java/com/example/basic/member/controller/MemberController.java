//package com.example.basic.member.controller;
//
//import jakarta.validation.Valid;
//import jakarta.validation.constraints.NotBlank;
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import lombok.Setter;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//@RequiredArgsConstructor
//public class MemberController {
//
//    @GetMapping("member/login")
//    public String login() {
//        return "member/login";
//    }
//
//    @Getter
//    @Setter
//    public static class LoginForm {
//        @NotBlank
//        private String username;
//        @NotBlank
//        private String password;
//    }
//
//    @PostMapping("member/login")
//    public String login(@Valid LoginForm loginForm, Model model) {
//        String dbUser = "hong";
//        String dbPass = "1234";
//
//        // 로그인 실패 -> 아이디가 잘못됐거나, 비밀번호 틀렸을 경우
//        if(!dbUser.equals(loginForm.username) || !dbPass.equals(loginForm.password)) {
//            return "member/login-fail";
//        }
//
//        model.addAttribute("logineduser",loginForm.username);
//
//        // 로그인 성공
//        return "redirect:/article/list";
//    }
//
//}
