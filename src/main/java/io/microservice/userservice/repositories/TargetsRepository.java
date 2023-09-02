package io.microservice.userservice.repositories;

import io.microservice.userservice.entities.Targets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TargetsRepository extends JpaRepository<Targets, Long> {
    // You can add custom query methods here if needed
}
