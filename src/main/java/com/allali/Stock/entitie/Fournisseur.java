package com.allali.Stock.entitie;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Fournisseur extends User{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @ManyToMany(mappedBy = "list")
    private List<Article> articleList ;
    @OneToMany(mappedBy = "fournisseur")
    private List<Transition> transitionList ;
}
