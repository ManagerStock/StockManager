package com.allali.Stock.service.article;

import com.allali.Stock.entitie.Article;
import com.allali.Stock.entitie.Category;
import com.allali.Stock.exceptions.ArticleNotFound;
import com.allali.Stock.exceptions.CategoryNotFoundException;
import com.allali.Stock.repositorie.ArticleRepository;
import com.allali.Stock.repositorie.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private ArticleRepository articleRepository ;
    private CategoryRepository categoryRepository;
    @Override
    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }
    @Override
    public void deleteArticle(Long id) {
        Article article = articleRepository.findById(id).orElse(null);
        articleRepository.deleteById(id);
        Category category = article.getCategory();
        category.getList().remove(article);
        categoryRepository.save(category);
    }
    @Override
    public Article updateArticle(Article article, Long id) throws ArticleNotFound {
        Article article1 = articleRepository.findById(id).orElse(null);
        if(article1==null) throw new ArticleNotFound("Article not found");
        article1.setName(article.getName());
        article1.setCategory(article.getCategory());
        article1.setPrice(article.getPrice());
        article1.setBrand(article.getBrand());
        article1.setDescription(article.getDescription());
        article1.setList(article.getList());
        article1.setTransition(article.getTransition());
        return articleRepository.save(article1);
    }
    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }
    @Override
    public void addArticleToCategory(Long idArtcile,Long idCategorie) throws CategoryNotFoundException, ArticleNotFound {
        Category category = categoryRepository.findById(idCategorie).orElse(null);
        Article article = articleRepository.findById(idArtcile).orElse(null);
        if(article == null) throw new ArticleNotFound("Article not found");
        if(category == null) throw new CategoryNotFoundException("Category Not Found");
        category.getList().add(article);
        article.setCategory(category);
        categoryRepository.save(category);
        articleRepository.save(article);
    }
}
