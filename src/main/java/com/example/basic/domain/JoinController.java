package com.example.basic.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class JoinController {

    @GetMapping("/join")
    public String join(){
        return "/join";
    }
}
