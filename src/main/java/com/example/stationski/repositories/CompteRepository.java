package com.example.stationski.repositories;

import com.example.stationski.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository  extends JpaRepository<Compte, Long> {

    Compte findByRib(String rib);
}
