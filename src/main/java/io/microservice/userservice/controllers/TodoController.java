package io.microservice.userservice.controllers;

import io.microservice.userservice.Service.interfaces.ITodoService;
import io.microservice.userservice.entities.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {



    @Autowired
    ITodoService iTodoService;

    @PostMapping
    public ResponseEntity<ToDo> createToDo(@RequestBody ToDo toDo) {
        ToDo createdToDo = iTodoService.createToDo(toDo);
        return ResponseEntity.ok(createdToDo);
    }

    @GetMapping
    public ResponseEntity<List<ToDo>> getAllToDos() {
        List<ToDo> todos = iTodoService.getAllToDos();
        return ResponseEntity.ok(todos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable Long id) {
        ToDo toDo = iTodoService.getToDoById(id);
        if (toDo != null) {
            return ResponseEntity.ok(toDo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

  /*  @PutMapping("/{id}")
    public ResponseEntity<ToDo> updateToDo(@PathVariable Long id, @RequestBody ToDo toDo) {
        ToDo existingToDo = iTodoService.getToDoById(id);
        if (existingToDo != null) {
            toDo.setId(id);
            ToDo updatedToDo = iTodoService.updateToDo(toDo);
            return ResponseEntity.ok(updatedToDo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable Long id) {
        iTodoService.deleteToDo(id);
        return ResponseEntity.noContent().build();
    }
}
