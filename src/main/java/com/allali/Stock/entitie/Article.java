package com.allali.Stock.entitie;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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

    // Lazy loading for category
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Category category ;

    // Lazy loading for list of fournisseurs
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Fournisseur> list = new ArrayList<>() ;

    // Lazy loading for transition
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Transition transition ;
}
