package io.microservice.userservice.controllers;


import io.microservice.userservice.Service.interfaces.ICompteServices;
import io.microservice.userservice.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Compte")
public class CompteController {
    @Autowired
    ICompteServices iCompteServices;

    @PostMapping("newCompte")
    Compte newCompte(@RequestBody Compte c){
        return iCompteServices.newCompte(c);
    }

    @PutMapping("updateCompte")
    Compte updateCompte(@RequestParam Long id,@RequestBody Compte c){
        return iCompteServices.updateCompte(id,c);
    }

    @DeleteMapping("deleteCompte")
    void deleteCompte(@RequestParam Long id){
        iCompteServices.deleteCompte(id);
    }

    @GetMapping("rechercheCompte")
    Compte rechercheCompte(@RequestParam String rib){
      return iCompteServices.rechercheCompte(rib);
    }
}
