package com.example.basic.domain.comment.controller;

import com.example.basic.domain.comment.servuice.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("write")
    public String write(String body){
        commentService.write(body);

        return "redirect:article/detail";
    }
}
