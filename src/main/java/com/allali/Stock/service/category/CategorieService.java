package com.allali.Stock.service.category;

import com.allali.Stock.entitie.Article;
import com.allali.Stock.entitie.Category;

import java.util.List;

public interface CategorieService {
    public Category addCategorie(Category category);
    public void deleteCategory(Long id );
    public Category updateCategory(Category category , Long id);
    public List<Category> findAll();
}
