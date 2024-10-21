package com.example.basic.domain.article.service;

import com.example.basic.domain.article.entity.Article;
import com.example.basic.domain.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    // 1. 기능 구현
    // 2. 유지 보수를 생각한 코드

    //작성
    public void write(String title, String body) {
        Article article = Article.builder()
                .title(title)
                .body(body)
                .build();

        articleRepository.save(article);
    }

    // 리스트
    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    // 상세보기
    public Article getById(long id) {
        Optional<Article> articleOpt = articleRepository.findById(id);

        if(articleOpt.isEmpty()) {
            throw new RuntimeException("존재하지 않는 게시물입니다.");
        }

        Article article = articleOpt.get();
        return article;
    }

    //수정
    public void update(long id, String title, String body) {
        Article article = getById(id);

        article.setTitle(title);
        article.setBody(body);

        articleRepository.save(article);
    }

    // 삭제
    public void deleteById(long id) {
        articleRepository.deleteById(id);
    }


}