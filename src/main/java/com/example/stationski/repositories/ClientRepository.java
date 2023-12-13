package com.example.stationski.repositories;


import com.example.stationski.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByNomAndPrenom(String nom, String prenom);
}
