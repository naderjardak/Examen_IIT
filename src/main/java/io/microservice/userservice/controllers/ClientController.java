package io.microservice.userservice.controllers;

import io.microservice.userservice.Service.interfaces.IClientServices;
import io.microservice.userservice.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Client")
public class ClientController {
    @Autowired
    IClientServices iClientServices;

    @PostMapping("newClient")
    Client newClient(@RequestBody Client c){
        return iClientServices.newClient(c);
    }

    @PutMapping("updateClien")
    Client updateClient(@RequestParam Long id,@RequestBody Client c){
        return iClientServices.updateClient(id,c);
    }

    @DeleteMapping("deleteClient")
    void deleteClient(@RequestParam Long id)
    {
        iClientServices.deleteClient(id);
    }

    @GetMapping("rechercherClient")
    List<Client> rechercherClient(@RequestParam String nom,@RequestParam String prenom){
        return iClientServices.rechercherClient(nom,prenom);
    }

}
