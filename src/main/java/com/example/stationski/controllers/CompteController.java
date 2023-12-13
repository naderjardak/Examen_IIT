package com.example.stationski.controllers;


import com.example.stationski.Service.interfaces.ICompteServices;
import com.example.stationski.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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

    @GetMapping("getAll")
    List<Compte> listCompte()
    {
        return iCompteServices.listCompte();
    }
}
