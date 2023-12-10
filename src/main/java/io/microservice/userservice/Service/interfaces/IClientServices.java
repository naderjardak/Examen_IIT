package io.microservice.userservice.Service.interfaces;

import io.microservice.userservice.entities.Client;

import java.util.List;

public interface IClientServices {

    Client newClient(Client c);
    Client updateClient(Long id,Client c);
    void deleteClient(Long id);
    List<Client> rechercherClient(String nom, String prenom);


}
