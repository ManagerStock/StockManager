package com.allali.Stock.service.article;

import com.allali.Stock.entitie.Article;
import com.allali.Stock.exceptions.ArticleNotFound;
import com.allali.Stock.exceptions.CategoryNotFoundException;

import java.util.List;

public interface ArticleService {
    public Article addArticle(Article article);
    public void deleteArticle(Long id );
    public Article updateArticle(Article article , Long id) throws ArticleNotFound;
    public List<Article> findAll();
    public void addArticleToCategory(Long idArtcile ,Long idCategorie) throws CategoryNotFoundException, ArticleNotFound;
}
