package io.microservice.userservice.Service.interfaces;

import io.microservice.userservice.entities.Compte;

public interface ICompteServices {

    Compte newCompte(Compte c);
    Compte updateCompte(Long id,Compte c);
    void deleteCompte(Long id);
    Compte rechercheCompte(String rib);
}
