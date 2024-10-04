package com.example.basic;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleDao {
    void write(Article article);

    public List<Article> list();

    public Article detail(Long id);

    void delete(Long id);

    //void modify(@Param("id")Long id, @Param("title")String title, @Param("body")String body);
    void modify(Article article);

    public List<Comment> comment();


}

