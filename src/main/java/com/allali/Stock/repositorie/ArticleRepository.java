package com.allali.Stock.repositorie;

import com.allali.Stock.entitie.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
