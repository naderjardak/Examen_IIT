package io.microservice.userservice.repositories;

import io.microservice.userservice.entities.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Games, Long> {
    List<Games> findAllByIdIn(List<Long> gameIds);
}
