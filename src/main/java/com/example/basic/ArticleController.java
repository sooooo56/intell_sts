package com.example.basic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleDao articleDao;

    @GetMapping("/article/write")
    public String articleWrite() {
        return "article/article-write";
    }

    @PostMapping("/article/write")
    @ResponseBody
    public String write(String title, String body) {
        Article article = Article.builder()
                .title(title)
                .body(body)
                .build();

        articleDao.write(article);

        return "게시물이 성공적으로 저장되었습니다";
    }

    @RequestMapping("/article/list")
    @ResponseBody
    public List<Article> list() {
        return articleDao.list();
    }

    @RequestMapping("/article/detail")
    @ResponseBody
    public Article detail(Long id) {
        Article articleList = articleDao.detail(id);

        return articleList;
    }

    @RequestMapping("/article/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id) {
        articleDao.delete(id);

        return "게시물을 삭제하였습니다";
    }

    @RequestMapping("/article/modify/{id}")
    @ResponseBody
    public String modify(@PathVariable("id") long id, String title, String body) {
        // 빌더 방식
        Article article = Article.builder()
                .id(id)
                .title(title)
                .body(body)
                .build();

        articleDao.modify(article);

        return "게시물이 수정되었습니다";
    }


}