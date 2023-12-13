package com.example.stationski.Service.interfaces;


import com.example.stationski.entities.Compte;

import java.util.List;

public interface ICompteServices {

    Compte newCompte(Compte c);
    Compte updateCompte(Long id,Compte c);
    void deleteCompte(Long id);
    Compte rechercheCompte(String rib);
    List<Compte> listCompte();
}
