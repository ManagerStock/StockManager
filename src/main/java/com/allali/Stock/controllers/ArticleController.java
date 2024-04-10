package com.allali.Stock.controllers;

import com.allali.Stock.entitie.Article;
import com.allali.Stock.entitie.Category;
import com.allali.Stock.exceptions.ArticleNotFound;
import com.allali.Stock.exceptions.CategoryNotFoundException;
import com.allali.Stock.repositorie.CategoryRepository;
import com.allali.Stock.service.article.ArticleService;
import com.allali.Stock.service.category.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/article")
@AllArgsConstructor
@CrossOrigin("*")
public class ArticleController {
    private final ArticleService articleService;
    private final CategoryRepository categoryRepository ;

    @PostMapping("/add/{categoryId}")
    public ResponseEntity<Article> addArticle(@RequestBody Article article, @PathVariable Long categoryId) throws CategoryNotFoundException {
        // Fetch the category from the database using the categoryId
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with ID: " + categoryId));

        // Associate the category with the article
        article.setCategory(category);

        // Save the article
        Article addedArticle = articleService.addArticle(article);

        return new ResponseEntity<>(addedArticle, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) throws ArticleNotFound {
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Article> updateArticle(@RequestBody Article article, @PathVariable Long id) {
        try {
            Article updatedArticle = articleService.updateArticle(article, id);
            return ResponseEntity.ok(updatedArticle);
        } catch (ArticleNotFound e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public List<Article> getAllArticles() {
        List<Article> articles = articleService.findAll();
        return articles;
    }

    @PostMapping("/add-to-category")
    public ResponseEntity<Void> addArticleToCategory(@RequestParam Long articleId, @RequestParam Long categoryId) {
        try {
            articleService.addArticleToCategory(articleId, categoryId);
            return ResponseEntity.ok().build();
        } catch (CategoryNotFoundException | ArticleNotFound e) {
            return ResponseEntity.notFound().build();
        }
    }
}
