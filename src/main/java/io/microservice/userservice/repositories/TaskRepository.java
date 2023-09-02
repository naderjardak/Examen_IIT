package io.microservice.userservice.repositories;

import io.microservice.userservice.entities.Task;
import io.microservice.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> findByUserToTask(User u);
}
