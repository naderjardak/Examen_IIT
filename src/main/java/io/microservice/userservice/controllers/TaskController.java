package io.microservice.userservice.controllers;



import io.microservice.userservice.Service.interfaces.ITaskService;
import io.microservice.userservice.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("Task")
public class TaskController {

    @Autowired
    ITaskService iTaskService;


    @PostMapping("/addtaches")
    public Task Createtaches(@RequestBody Task t) {
        return iTaskService.addTaches(t);
    }

    @GetMapping("GetTachesById")
    public Task getById(@RequestParam Long id) {
        return iTaskService.getTachesById(id);
    }

    @GetMapping("/getALLTaches")
    public List<Task> GetTachesAll(){
        return iTaskService.getAllTaches();
    }

    @DeleteMapping("/deleteTaches")
    void deleteTaches (@RequestParam long id) {
        iTaskService.deleteTaches(id);
    }



    @DeleteMapping("/deleteTask")
    public void deleteTask(@RequestParam Long taskId){
    iTaskService.deleteTask(taskId);
    }



    @GetMapping("/AllSessionTasks")
    public List<Task> AllSessionTasks(){return iTaskService.AllSessionTasks();}

}
