package io.microservice.userservice.repositories;

import io.microservice.userservice.entities.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<ToDo, Long> {
    // You can add custom query methods here if needed
}
