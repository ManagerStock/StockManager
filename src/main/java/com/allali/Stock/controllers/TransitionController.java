package com.allali.Stock.controllers;

import com.allali.Stock.entitie.Transition;
import com.allali.Stock.service.transition.TransitionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transition")
@AllArgsConstructor
public class TransitionController {
    private final TransitionService transitionService;

    @PostMapping("/add-fournisseur")
    public ResponseEntity<Transition> addTransitionFournisseur(@RequestBody Transition transition) {
        Transition addedTransition = transitionService.addTransitionFournisseur(transition);
        return new ResponseEntity<>(addedTransition, HttpStatus.CREATED);
    }

    @PostMapping("/add-client")
    public ResponseEntity<Transition> addTransitionClient(@RequestBody Transition transition) {
        Transition addedTransition = transitionService.addTransitionClient(transition);
        return new ResponseEntity<>(addedTransition, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTransition(@PathVariable Long id) {
        transitionService.deleteTransition(id);
        return ResponseEntity.noContent().build();
    }}