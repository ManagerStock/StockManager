package com.allali.Stock.service.transition;

import com.allali.Stock.entitie.Transition;
import com.allali.Stock.repositorie.TransitionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransitionServiceImpl implements TransitionService {
    private TransitionRepository transitionRepository ;
    @Override
    public Transition addTransitionFournisseur(Transition transition) {
        return transitionRepository.save(transition);
    }

    @Override
    public void deleteTransition(Long id) {
        transitionRepository.deleteById(id);
    }

    @Override
    public Transition addTransitionClient(Transition transition) {
        return transitionRepository.save(transition);
    }
}
