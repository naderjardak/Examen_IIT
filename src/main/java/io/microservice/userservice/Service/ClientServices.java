package io.microservice.userservice.Service;

import io.microservice.userservice.Service.interfaces.IClientServices;
import io.microservice.userservice.entities.Client;
import io.microservice.userservice.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServices implements IClientServices {
    @Autowired
    ClientRepository clientRepository;


    @Override
    public Client newClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public Client updateClient(Long id, Client c) {
        c.setId(id);
        return clientRepository.save(c);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<Client> rechercherClient(String nom, String prenom) {
        return clientRepository.findByNomAndPrenom(nom, prenom);
    }
}
