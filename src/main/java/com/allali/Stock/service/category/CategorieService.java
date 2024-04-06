package com.allali.Stock.service.category;

import com.allali.Stock.entitie.Article;
import com.allali.Stock.entitie.Category;
import com.allali.Stock.exceptions.CategoryNotFoundException;

import java.util.List;

public interface CategorieService {
    public Category addCategorie(Category category);
    public void deleteCategory(Long id );
    public Category updateCategory(Category category , Long id) throws CategoryNotFoundException;
    public List<Category> findAll();
}
