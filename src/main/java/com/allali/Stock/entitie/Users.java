package com.allali.Stock.entitie;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE" ,length =6 , discriminatorType = DiscriminatorType.STRING)
@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class Users {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String firstName ;
    private String lastName ;
    private String email ;
    private String address ;
    private String phoneNumber ;
    private Date dateNaissance ;

    // Lazy loading for list of roles
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Role> list = new ArrayList<>();

    // Lazy loading for list of notifications
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Notification> notificationList = new ArrayList<>();
}
