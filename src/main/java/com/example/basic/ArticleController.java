package com.example.basic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleDao articleDao;

    //작성
    @GetMapping("/article/write")
    public String articleWrite() {
        return "article/write";
    }

    @PostMapping("/article/write")
    public String write(String title, String body) {
        Article article = Article.builder()
                .title(title)
                .body(body)
                .build();

        articleDao.write(article);

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
    public String detail(@PathVariable("id") Long id, Model model) {
        Article article = articleDao.detail(id);
        model.addAttribute("article", article);

        return "article/detail";
    }

    //삭제
    @RequestMapping("/article/delete/{id}")
    public String delete(@PathVariable Long id) {
        articleDao.delete(id);

        return "redirect:/article/list";
    }

    // 수정
    @RequestMapping("/article/modify/{id}")
    public String modify(@PathVariable("id") long id, String title, String body, Model model) {
        // 빌더 방식
        Article article = Article.builder()
                .id(id)
                .title(title)
                .body(body)
                .build();

        articleDao.modify(article);
        model.addAttribute("article",article);

        return "redirect:/article/detail/%d".formatted(id);
    }


}