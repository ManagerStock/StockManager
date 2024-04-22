package com.allali.Stock.service.category;

import com.allali.Stock.entitie.Category;
import com.allali.Stock.exceptions.CategoryNotFoundException;
import com.allali.Stock.repositorie.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategorieServiceImpl implements CategorieService {
    private CategoryRepository categoryRepository ;
    @Override
    public Category addCategorie(Category category) {
        return categoryRepository.save(category);
    }
    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
    @Override
    public Category updateCategory(Category category, Long id) throws CategoryNotFoundException {
        Category category1 = categoryRepository.findById(id).orElse(null);
        if (category1==null) throw new CategoryNotFoundException("Category not found");
        category1.setDescription(category.getDescription());
        category1.setName(category.getName());
        //category1.setList(category.getList());
        return categoryRepository.save(category1);
    }
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
