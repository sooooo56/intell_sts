package com.example.basic.article.controller;

import com.example.basic.article.dao.ArticleDao;
import com.example.basic.article.entity.Article;
import com.example.basic.article.service.ArticleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleDao articleDao;
    private final ArticleService articleService;

    //작성
    @GetMapping("/article/write")
    public String articleWrite() {
        return "article/write";
    }

    @Getter
    public static class WriteForm{
        @NotBlank
        private String title;
        @NotBlank
        private String body;
    }

    @PostMapping("/article/write")
    public String write(@Valid WriteForm WriteForm) {

        if(WriteForm.getTitle().trim().length() == 0 || WriteForm.getTitle() == null) {
            throw new IllegalArgumentException("제목은 공백일 수 없습니다.");
        }

        if(WriteForm.getBody().trim().length() == 0 || WriteForm.getBody() == null) {
            throw new IllegalArgumentException("내용은 공백일 수 없습니다.");
        }

        articleService.write(title, body);

        return "redirect:/article/list";
        //redirect 뒤에 적는 것은 url을 적는 것. 템플릿 이름 아님. 주소창을 해당 url로 바꾸라는 의미
    }

    //목록
    @GetMapping("/article/list")
    public String list(Model model) {
        List<Article> articleList = articleDao.list();

        model.addAttribute("articleList", articleList);

        return "article/list";
    }

    //상세보기
    @RequestMapping("/article/detail/{id}")
    public String detail(@PathVariable("id") long id, Model model) {
        Article article = articleService.getById(id); // 데이터 처리(비지니스 로직)
        model.addAttribute("article", article); // 웹 관련 처리

        return "article/detail";
    }

    //삭제
    @RequestMapping("/article/delete/{id}")
    public String delete(@PathVariable Long id) {
        articleService.delete(id);

        return "redirect:/article/list";
    }

    // 수정
    @Getter
    public static class ModifyForm{
        @NotBlank
        private String title;
        @NotBlank
        private String body;
    }

    @RequestMapping("/article/modify/{id}")
    public String modify(@PathVariable("id") long id, @Valid ModifyForm ModifyForm) {
        // 빌더 방식
        Article article = Article.builder()
                .id(id)
                .title(ModifyForm.getTitle())
                .body(ModifyForm.getBody())
                .build();

        articleService.modify(article);

        return "redirect:/article/detail/%d".formatted(id);
    }




}