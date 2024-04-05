package com.allali.Stock.entitie;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Client extends User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @OneToMany(mappedBy = "client")
    private List<Transition> transitionList ;
}
