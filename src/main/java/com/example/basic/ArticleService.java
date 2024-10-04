package com.example.basic;

public class ArticleService {

    private ArticleDao articleDao;

    public Article getbyId(long id){
        Article article = articleDao.detail(id);
        return article;
    }
}
