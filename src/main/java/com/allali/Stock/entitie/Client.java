package com.allali.Stock.entitie;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("CLI")
@Data
@AllArgsConstructor @NoArgsConstructor

public class Client extends User {

    @OneToMany(mappedBy = "client")
    private List<Transition> transitionList ;
}
