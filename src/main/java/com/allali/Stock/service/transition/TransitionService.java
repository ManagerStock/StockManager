package com.allali.Stock.service.transition;

import com.allali.Stock.entitie.Transition;

import java.util.List;

public interface TransitionService {
    public Transition addTransitionFournisseur(Transition transition);
    public void deleteTransition(Long id);


    Transition addTransitionClient(Transition transition, Long idClient, Long idArticle);

    List<Transition> findAll();
}
