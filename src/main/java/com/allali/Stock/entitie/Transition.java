package com.allali.Stock.entitie;

import com.allali.Stock.enums.TransactionStatus;
import com.allali.Stock.enums.TransitionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Transition {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Double totalAmount ;
    private Date transactionDate ;
    private TransactionStatus status ;
    private TransitionType transitionType ;
    @ManyToOne
    private Client client ;
    @ManyToOne
    private Fournisseur fournisseur ;
    @OneToMany(mappedBy = "transition" , fetch = FetchType.LAZY ,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Article> articleList = new ArrayList<>() ;

}
