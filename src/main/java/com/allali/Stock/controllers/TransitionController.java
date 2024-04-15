package com.allali.Stock.controllers;

import com.allali.Stock.entitie.Article;
import com.allali.Stock.entitie.Client;
import com.allali.Stock.entitie.Transition;
import com.allali.Stock.service.article.ArticleService;
import com.allali.Stock.service.transition.TransitionService;
import com.allali.Stock.service.users.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transition")
@AllArgsConstructor
public class TransitionController {
    private final TransitionService transitionService;
    private final ArticleService articleService ;
    private final UserService userService ;

    @PostMapping("/add-fournisseur")
    public ResponseEntity<Transition> addTransitionFournisseur(@RequestBody Transition transition) {
        Transition addedTransition = transitionService.addTransitionFournisseur(transition);
        return new ResponseEntity<>(addedTransition, HttpStatus.CREATED);
    }

    @PostMapping("/add/{idClient}/{idArticle}")
    public ResponseEntity<Transition> addTransitionClient(@RequestBody Transition transition,
                                                          @PathVariable Long idClient,
                                                          @PathVariable Long idArticle) {
        Transition addedTransition = transitionService.addTransitionClient(transition,idClient,idArticle);
        return new ResponseEntity<>(addedTransition, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<Transition> getAllTransition() {
        List<Transition> transitions = transitionService.findAll();
        return transitions;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTransition(@PathVariable Long id) {
        transitionService.deleteTransition(id);
        return ResponseEntity.noContent().build();
    }}