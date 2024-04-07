package com.allali.Stock.service.transition;

import com.allali.Stock.entitie.Transition;

public interface TransitionService {
    public Transition addTransitionFournisseur(Transition transition);
    public void deleteTransition(Long id);
    public Transition addTransitionClient(Transition transition);
}
