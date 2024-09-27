package com.example.basic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final ArticleDao articleDao;

    @RequestMapping("/article/write")
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

    @RequestMapping("/show-html")
    public String showHtml() {
        return "test"; // .html 확장자를 스프링부트가 자동으로 붙여줌
    }


}