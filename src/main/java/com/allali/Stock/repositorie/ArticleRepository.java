package com.allali.Stock.repositorie;

import com.allali.Stock.entitie.Article;
import com.allali.Stock.entitie.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Long> {

}
