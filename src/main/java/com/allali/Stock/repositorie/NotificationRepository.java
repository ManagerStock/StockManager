package com.allali.Stock.repositorie;

import com.allali.Stock.entitie.Article;
import com.allali.Stock.entitie.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
}
