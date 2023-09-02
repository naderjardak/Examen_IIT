package io.microservice.userservice.repositories;

import io.microservice.userservice.entities.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    @Query("SELECT e FROM Experience e WHERE e.user.id = :userId")
    List<Experience> findByUserId(@Param("userId") Long userId);
}
