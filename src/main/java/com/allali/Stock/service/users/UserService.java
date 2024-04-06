package com.allali.Stock.service.users;

import com.allali.Stock.entitie.Client;
import com.allali.Stock.entitie.Fournisseur;
import com.allali.Stock.entitie.Users;

public interface UserService {
    public Fournisseur saveFournisseur(Fournisseur fournisseur);
    public Fournisseur updateFournisseur(Fournisseur fournisseur , Long id);
    public Client saveClient(Client client);
    public Client updateClient(Client client , Long id);
    public void deleteUser(Long id);
    public Users getUser(Long id);
}
