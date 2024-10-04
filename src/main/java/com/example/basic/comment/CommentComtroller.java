package com.example.basic.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CommentComtroller {
    // 댓글
//    @GetMapping("/article/comment")
//    public String comment(Model model) {
//        List<Comment> commentList = articleDao.comment();
//        model.addAttribute("commentList", commentList);
//
//        return "article/comment";
//    }
//
//    @RequestMapping("/article/comment")
//    public String comment(long id, @NotBlank String txt){
//        Comment comment = Comment.builder()
//                .id(id)
//                .txt(txt)
//                .build();
//
//        articleDao.comment();
//
//        return "redirect:/article/detail/%d".formatted(id);
//    }
}
