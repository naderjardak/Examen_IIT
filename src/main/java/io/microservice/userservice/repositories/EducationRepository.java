package io.microservice.userservice.repositories;

import io.microservice.userservice.entities.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
    @Query("SELECT edu FROM Education edu WHERE edu.user.id = :userId")
    List<Education> findByUserId(@Param("userId") Long userId);

}
