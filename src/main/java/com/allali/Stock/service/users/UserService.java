package com.allali.Stock.service.users;

import com.allali.Stock.entitie.Client;
import com.allali.Stock.entitie.Fournisseur;
import com.allali.Stock.entitie.Users;

import java.util.List;

public interface  UserService {
    public Fournisseur saveFournisseur(Fournisseur fournisseur);

    Users saveUser(Users users);

    public Fournisseur updateFournisseur(Fournisseur fournisseur , Long id);
    public Client saveClient(Client client);
    public Client updateClient(Client client , Long id);
    public void deleteUser(Long id);
    public Users getUser(Long id);

    List<Users> users();
}
