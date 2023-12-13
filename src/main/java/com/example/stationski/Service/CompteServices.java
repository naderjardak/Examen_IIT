package com.example.stationski.Service;


import com.example.stationski.Service.interfaces.ICompteServices;
import com.example.stationski.entities.Compte;
import com.example.stationski.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteServices implements ICompteServices {
    @Autowired
    CompteRepository compteRepository;


    @Override
    public Compte newCompte(Compte c) {
        return compteRepository.save(c);
    }

    @Override
    public Compte updateCompte(Long id, Compte c) {
        c.setId(id);
        return compteRepository.save(c);
    }

    @Override
    public void deleteCompte(Long id) {
        compteRepository.deleteById(id);
    }

    @Override
    public Compte rechercheCompte(String rib) {
        return compteRepository.findByRib(rib);
    }

    @Override
    public List<Compte> listCompte() {
        return compteRepository.findAll();
    }
}
