package com.example.basic.domain.article.dao;

import com.example.basic.domain.article.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleDao {
    void write(Article article);
    public List<Article> findAll();
    public Article detail(Long id);
    void delete(Long id);
    //void modify(@Param("id")Long id, @Param("title")String title, @Param("body")String body);
    void modify(Article article);
    void comment(String comment);

//    ArticleRepository articleRepository;
//
//    public void save(Long id, String title, String body){
//        Article article = Article.builder()
//                .id(id)
//                .title(title)
//                .body(body)
//                .build();
//
//        ArticleRepository.save();
//    }


}

