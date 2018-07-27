package com.grand.enoteboot.service;

import com.grand.enoteboot.entity.Article;

import java.util.List;

public interface ArticleService {
    List<Article> findAll();
    void addArticle(Article article);
    Article findById(Long id);
    void update(Article article);
    void delete(Long id);
}
