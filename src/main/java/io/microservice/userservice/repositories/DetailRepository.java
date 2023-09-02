package io.microservice.userservice.repositories;

import io.microservice.userservice.entities.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {

}
