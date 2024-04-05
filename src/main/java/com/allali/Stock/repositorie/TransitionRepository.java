package com.allali.Stock.repositorie;

import com.allali.Stock.entitie.Article;
import com.allali.Stock.entitie.Transition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransitionRepository extends JpaRepository<Transition,Long> {
}
