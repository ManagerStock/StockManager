package com.allali.Stock.service.transition;

import com.allali.Stock.entitie.Article;
import com.allali.Stock.entitie.Client;
import com.allali.Stock.entitie.Transition;
import com.allali.Stock.repositorie.ArticleRepository;
import com.allali.Stock.repositorie.TransitionRepository;
import com.allali.Stock.repositorie.UserRepository;
import com.allali.Stock.service.article.ArticleService;
import com.allali.Stock.service.users.UserService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class TransitionServiceImpl implements TransitionService {
    private TransitionRepository transitionRepository ;
    private final ArticleService articleService ;
    private final UserService userService ;
    private final ArticleRepository articleRepository ;
    private final UserRepository userRepository ;
    @Override
    public Transition addTransitionFournisseur(Transition transition) {
        return transitionRepository.save(transition);
    }

    @Override
    public void deleteTransition(Long id) {
        transitionRepository.deleteById(id);
    }

    @Override
    public Transition addTransitionClient(Transition transition, Long idClient, Long idArticle) {
        // Retrieve the client and article entities
        Client client = (Client) userService.getUser(idClient);
        Article article = articleService.find(idArticle);

        // Set transaction details in the transition entity
        transition.setTransactionDate(new Date());
        transition.setTotalAmount(article.getPrice());

        // Set the client and article in the transition entity
        transition.setClient(client);
        transition.getArticle().add(article);

        // Add the transition to the client's transition list
        client.getTransitionList().add(transition);

        // Save the client, which cascades to save the transition as well
        userRepository.save(client);

        return transition;
    }


    @Override
    @JsonIgnore
    public List<Transition> findAll() {
        return transitionRepository.findAll();
    }

}