package com.allali.Stock.service;

import com.allali.Stock.entitie.*;
import com.allali.Stock.enums.TransactionStatus;
import com.allali.Stock.enums.TransitionType;
import com.allali.Stock.repositorie.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;

@Service
@Transactional
@AllArgsConstructor
public class Initiation {
    private ArticleRepository articleRepository ;
    private CategoryRepository categoryRepository ;
    private NotificationRepository notificationRepository ;
    private UserRepository userRepository ;
    private TransitionRepository transitionRepository ;
    public void initArticle(){
        Stream.of("Computer","Phone","TV").forEach(product->{
            userRepository.findAll().forEach(user->{
                if(user instanceof Fournisseur){
                    Category category = categoryRepository.findByName("Electronics");
                    Article article = new Article();
                    article.setName(product);
                    article.setCategory(category);
                    article.setPrice(5540.5);
                    article.getList().add((Fournisseur)user);
                    articleRepository.save(article);
                    ((Fournisseur) user).getArticleList().add(article);
                    category.getList().add(article);
                    userRepository.save(user);
                    categoryRepository.save(category);
                }

            });

        });
    }
    public void initCategory(){
        Stream.of("Health","Electronics","Toys").forEach(category->{
            Category category1 = new Category();
            category1.setName(category);
            category1.setDescription("Products related to personal well-being, including medications, supplements, and hygiene items.");
            categoryRepository.save(category1);
        });

    }
    public void initNotification(){

    }
    public void initTransition(){
        userRepository.findAll().forEach(user -> {
            if (user instanceof Client) {
                Article article = articleRepository.findById(1L).orElse(null);
                Transition transition = new Transition();
                transition.setTotalAmount(2004.5);
                transition.setTransactionDate(new Date());
                transition.setStatus(TransactionStatus.COMPLETED);
                transition.setTransitionType(TransitionType.ACHAT);
                transition.setClient((Client) user);
                transition.getArticleList().add(article);
                ((Client) user).getTransitionList().add(transition);
                userRepository.save(user);
                transitionRepository.save(transition);
            }
        });
    }
    public void initTransition2(){
        userRepository.findAll().forEach(user -> {
              if(user instanceof Fournisseur) {
                Article article = articleRepository.findById(2L).orElse(null);
                Transition transition1 = new Transition();
                transition1.setTotalAmount(2004.5);
                transition1.setTransactionDate(new Date());
                transition1.setStatus(TransactionStatus.COMPLETED);
                transition1.setTransitionType(TransitionType.ACHAT);
                transition1.setFournisseur((Fournisseur)user);
                transition1.getArticleList().add(article);
                ((Fournisseur) user).getTransitionList().add(transition1);
                article.setTransition(transition1);
                articleRepository.save(article);
                userRepository.save(user);
                transitionRepository.save(transition1);
            }
        });
    }
    public void initFournisseur(){
        Stream.of("Hassan","Hamid" ,"Amine").forEach(name->{
            Fournisseur fournisseur = new Fournisseur();
            fournisseur.setFirstName(name);
            fournisseur.setLastName(name);
            fournisseur.setAddress(name+"Mexico");
            fournisseur.setEmail(name+"@gmail.com");
            fournisseur.setDateNaissance(new Date());
            fournisseur.setPhoneNumber("065554584");
            userRepository.save(fournisseur);
        });
    }
    public void initClient(){
        Stream.of("Hassan","Hamid" ,"Amine").forEach(name->{
            Client client = new Client();
            client.setFirstName(name);
            client.setLastName(name);
            client.setAddress(name+"Mexico");
            client.setEmail(name+"@gmail.com");
            client.setDateNaissance(new Date());
            client.setPhoneNumber("065554584");
            userRepository.save(client);
        });
    }

}
