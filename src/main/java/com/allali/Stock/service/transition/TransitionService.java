package com.allali.Stock.service.transition;

import com.allali.Stock.entitie.Transition;

public interface TransitionService {
    public Transition addTransition(Transition transition);
    public Transition updateTransition(Transition transition , Long id);
    public void deleteTransition(Long id);

}
