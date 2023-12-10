package io.microservice.userservice.repositories;

import io.microservice.userservice.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository  extends JpaRepository<Compte, Long> {

    Compte findByRib(String rib);
}
