package com.allali.Stock.repositorie;

import com.allali.Stock.entitie.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
}
