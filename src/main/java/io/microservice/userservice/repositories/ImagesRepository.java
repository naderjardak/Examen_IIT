package io.microservice.userservice.repositories;

import io.microservice.userservice.entities.Appointment;
import io.microservice.userservice.entities.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagesRepository extends JpaRepository<Images, Long> {
}
