package com.allali.Stock.service;

import com.allali.Stock.entitie.Article;
import com.allali.Stock.entitie.Category;
import com.allali.Stock.entitie.Client;
import com.allali.Stock.entitie.Fournisseur;
import com.allali.Stock.repositorie.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;

@Service
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
                    ((Fournisseur) user).getArticleList().add(article);
                    article.getList().add((Fournisseur)user);
                    category.getList().add(article);
                    userRepository.save(user);
                    categoryRepository.save(category);
                    articleRepository.save(article);
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

    }
    public void initUser(){
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
