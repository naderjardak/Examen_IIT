package io.microservice.userservice.Service;

import io.microservice.userservice.repositories.TodoRepository;
import io.microservice.userservice.Service.interfaces.ITodoService;
import io.microservice.userservice.entities.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService implements ITodoService {



    @Autowired
    TodoRepository todoRepository;

    @Override
    public ToDo createToDo(ToDo toDo) {
        return todoRepository.save(toDo);
    }

    @Override
    public List<ToDo> getAllToDos() {
        return todoRepository.findAll();
    }

    @Override
    public ToDo getToDoById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    @Override
    public ToDo updateToDo(ToDo toDo) {
        return todoRepository.save(toDo);
    }

    @Override
    public void deleteToDo(Long id) {
        todoRepository.deleteById(id);
    }
}
