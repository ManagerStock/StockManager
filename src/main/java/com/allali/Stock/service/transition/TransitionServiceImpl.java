package com.allali.Stock.service.transition;

import com.allali.Stock.entitie.Article;
import com.allali.Stock.entitie.Client;
import com.allali.Stock.entitie.Transition;
import com.allali.Stock.repositorie.ArticleRepository;
import com.allali.Stock.repositorie.TransitionRepository;
import com.allali.Stock.repositorie.UserRepository;
import com.allali.Stock.service.article.ArticleService;
import com.allali.Stock.service.users.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        Optional<Transition> transitionOptional = transitionRepository.findById(id);
        if (transitionOptional.isPresent()) {
            Transition transition = transitionOptional.get();
            // Delete associated articles
            List<Article> articles = transition.getArticleList();
            for (Article article : articles) {
                article.setTransition(null); // Remove the reference to the transition
                articleRepository.save(article);
            }
            // Clear the article list from the transition
            transition.getArticleList().clear();
            // Delete the transition
            transitionRepository.delete(transition);


        }    }

    @Override
    public Transition addTransitionClient(Transition transition, Long idClient, Long idArticle) {
        // Retrieve the client and article entities
        Client client = (Client) userService.getUser(idClient);
        Article article = articleService.find(idArticle);

        // Set transaction details in the transition entity
        transition.setTransactionDate(new Date());
        transition.setTotalAmount(article.getPrice());
        client.getTransitionList().add(transition);
        userRepository.save(client);
        articleRepository.save(article);


        // Set client and article in the transition entity
        transition.setClient(client);
        transition.getArticleList().add(article);
        Transition transition1 =transitionRepository.save(transition);

        client.getTransitionList().add(transition1);
        article.setTransition(transition);
        userRepository.save(client);
        articleRepository.save(article);

        return transition1 ;

    }

    @Override
    public List<Transition> findAll() {
        return transitionRepository.findAll();
    }

}
