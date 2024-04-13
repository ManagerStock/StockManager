package com.allali.Stock.controllers;

import com.allali.Stock.entitie.Client;
import com.allali.Stock.entitie.Fournisseur;
import com.allali.Stock.entitie.Users;
import com.allali.Stock.service.users.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/user")
    public ResponseEntity<Users> saveUser(@RequestBody Users user) {
        Users savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }


    @PostMapping("/fournisseur")
    public ResponseEntity<Fournisseur> saveFournisseur(@RequestBody Fournisseur fournisseur) {
        Fournisseur savedFournisseur = userService.saveFournisseur(fournisseur);
        return new ResponseEntity<>(savedFournisseur, HttpStatus.CREATED);
    }

    @PutMapping("/fournisseur/{id}")
    public ResponseEntity<Fournisseur> updateFournisseur(@RequestBody Fournisseur fournisseur, @PathVariable Long id) {
        Fournisseur updatedFournisseur = userService.updateFournisseur(fournisseur, id);
        if (updatedFournisseur != null) {
            return ResponseEntity.ok(updatedFournisseur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/client")
    public ResponseEntity<Client> saveClient(@RequestBody Client client) {
        Client savedClient = userService.saveClient(client);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    @PutMapping("/client/{id}")
    public ResponseEntity<Client> updateClient(@RequestBody Client client, @PathVariable Long id) {
        Client updatedClient = userService.updateClient(client, id);
        if (updatedClient != null) {
            return ResponseEntity.ok(updatedClient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUser(@PathVariable Long id) {
        Users user = userService.getUser(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}