package io.microservice.userservice.Service;

import io.microservice.userservice.Service.interfaces.ICompteServices;
import io.microservice.userservice.entities.Compte;
import io.microservice.userservice.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
