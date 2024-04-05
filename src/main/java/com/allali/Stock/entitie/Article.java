package com.allali.Stock.entitie;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private String description ;
    private Double price ;
    private String brand ;
    @ManyToOne
    private Category category ;
    @ManyToMany
    private List<Fournisseur> list ;
    @ManyToOne
    private Transition transition ;

}
