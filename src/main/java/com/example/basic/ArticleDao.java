package com.example.basic;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleDao {
    void write(@Param("title") String title, @Param("body") String body);

    public List<Article> list();

    public Article detail(Long id);

    void delete(Long id);

    void modify(@Param("id")Long id, @Param("title")String title, @Param("body")String body);
}

