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
    @ManyToOne
    @JsonIgnore
    private Category category ;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Fournisseur> list = new ArrayList<>() ;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Transition transition ;

}
