package com.allali.Stock.entitie;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@DiscriminatorValue("FOUR")
@AllArgsConstructor @NoArgsConstructor
public class Fournisseur extends User{
    @ManyToMany(mappedBy = "list")
    private List<Article> articleList ;
    @OneToMany(mappedBy = "fournisseur")
    private List<Transition> transitionList ;
}
