package com.example.stationski.Service.interfaces;


import com.example.stationski.entities.Client;

import java.util.List;

public interface IClientServices {

    Client newClient(Client c);
    Client updateClient(Long id,Client c);
    void deleteClient(Long id);
    List<Client> rechercherClient(String nom, String prenom);
    List<Client> listClient();


}
