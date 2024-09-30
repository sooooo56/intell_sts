package com.example.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/test/html")
    public String showHtml() {
        return "test/test"; // .html 확장자를 스프링부트가 자동으로 붙여줌
    }

    @RequestMapping("/test/fruits")
    public String fruits(){
        return "test/fruits";
    }

    @RequestMapping("/test/va")
    public String variable(){
        return "test/variable";
    }

    @RequestMapping("/test/co")
    public String condition(){
        return "test/condition";
    }

    @RequestMapping("/test/loop")
    public String loop(){
        return "test/loop";
    }



}
