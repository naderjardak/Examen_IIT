package io.microservice.userservice.Service.interfaces;

import io.microservice.userservice.entities.ToDo;

import java.util.List;

public interface ITodoService {
    ToDo createToDo(ToDo toDo);
    List<ToDo> getAllToDos();
    ToDo getToDoById(Long id);
    ToDo updateToDo(ToDo toDo);
    void deleteToDo(Long id);
}
