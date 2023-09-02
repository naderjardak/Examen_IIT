package io.microservice.userservice.repositories;

import io.microservice.userservice.entities.Tests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestsRepository extends JpaRepository<Tests, Long> {
    // You can add custom query methods here if needed
}

