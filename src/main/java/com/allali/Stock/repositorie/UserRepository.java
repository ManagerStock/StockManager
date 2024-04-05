package com.allali.Stock.repositorie;

import com.allali.Stock.entitie.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
