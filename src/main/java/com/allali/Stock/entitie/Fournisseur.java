package com.allali.Stock.entitie;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@DiscriminatorValue("FOUR")
@AllArgsConstructor @NoArgsConstructor
public class Fournisseur extends Users {
    @ManyToMany()
    private List<Article> articleList= new ArrayList<>();
    @OneToMany(mappedBy = "fournisseur" , fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Transition> transitionList = new ArrayList<>() ;
    @OneToMany(mappedBy = "fournisseur",cascade = CascadeType.ALL)
    private List<PrixAchat> prixAchats ;
}
