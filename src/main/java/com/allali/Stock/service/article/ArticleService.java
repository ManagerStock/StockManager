package com.allali.Stock.service.article;

import com.allali.Stock.entitie.Article;

import java.util.List;

public interface ArticleService {
    public Article addArticle(Article article);
    public void deleteArticle(Long id );
    public Article updateArticle(Article article , Long id);
    public List<Article> findAll();
    public void addArticleToCategory(Long idCategorie);
    public void updateCaregorie(Long idCategorie);
}
