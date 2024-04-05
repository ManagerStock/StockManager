package com.allali.Stock.entitie;

import com.allali.Stock.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String firstName ;
    private String lastName ;
    private String email ;
    private String address ;
    private String phoneNumber ;
    private Date dateNaissance ;
    @ManyToMany
    private List<Role> list ;
    @ManyToMany
    private List<Notification> notificationList ;
}
