package com.allali.Stock.repositorie;

import com.allali.Stock.entitie.Article;
import com.allali.Stock.entitie.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(String name);
}
