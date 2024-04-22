package com.allali.Stock.controllers;

import com.allali.Stock.entitie.Category;
import com.allali.Stock.exceptions.CategoryNotFoundException;
import com.allali.Stock.repositorie.CategoryRepository;
import com.allali.Stock.service.category.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@AllArgsConstructor
public class CategoryController {
    private final CategorieService categoryService;
    private final CategoryRepository categoryRepository ;

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category addedCategory = categoryService.addCategorie(category);
        return new ResponseEntity<>(addedCategory, HttpStatus.CREATED);
    }
    @GetMapping("{categoryId}")
    public ResponseEntity<Category> getCategory(@PathVariable Long categoryId) {
        return new ResponseEntity<>(categoryRepository.findById(categoryId).orElse(null), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable Long id) {
        try {
            Category updatedCategory = categoryService.updateCategory(category, id);
            return ResponseEntity.ok(updatedCategory);
        } catch (CategoryNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.findAll();
        return ResponseEntity.ok(categories);
    }
}