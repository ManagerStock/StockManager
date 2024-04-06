package com.allali.Stock.service.users;

import com.allali.Stock.entitie.Client;
import com.allali.Stock.entitie.Fournisseur;
import com.allali.Stock.entitie.Users;
import com.allali.Stock.repositorie.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class UserServiceImpl implements UserService {
    private UserRepository userRepository ;
    @Override
    public Fournisseur saveFournisseur(Fournisseur fournisseur) {
        return userRepository.save(fournisseur);
    }
    @Override
    public Fournisseur updateFournisseur(Fournisseur fournisseur, Long id) {
        return null;
    }
    @Override
    public Client saveClient(Client client) {
        return userRepository.save(client);
    }

    @Override
    public Client updateClient(Client client, Long id) {
        return null;
    }
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public Users getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
