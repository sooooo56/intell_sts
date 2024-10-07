package com.example.basic.article.service;

import com.example.basic.article.entity.Article;
import com.example.basic.article.dao.ArticleDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleDao articleDao;

    //작성
    public void write(String title, String body) {
        // 코드 정리 단축키 -> 컨트롤 + 알트 + L
        Article article = Article.builder()
                .title(title)
                .body(body)
                .build();

        articleDao.write(article);
    }

    // 1. 기능 구현
    // 2. 유지 보수를 생각한 코드
    public Article getById(long id) {
        Article article = articleDao.detail(id); // 데이터 처리(비지니스 로직)
        return article;
    }

    public List<Article> getAll() {
        return articleDao.findAll();
    }


    public void deleteById(long id) {
        articleDao.delete(id);
    }

    public void update(long id, String title, String body) {
        // 빌더 방식
        Article article = Article.builder()
                .id(id)
                .title(title)
                .body(body)
                .build();

        articleDao.modify(article);
    }
}