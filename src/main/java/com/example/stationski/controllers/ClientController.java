package com.example.stationski.controllers;

import com.example.stationski.Service.interfaces.IClientServices;
import com.example.stationski.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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

    @GetMapping("listClient")
    List<Client> listClient()
    {
        return iClientServices.listClient();
    }


}
