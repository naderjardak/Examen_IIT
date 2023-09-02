package io.microservice.userservice.Service;


import io.microservice.userservice.Service.interfaces.ITaskService;
import io.microservice.userservice.configuration.SessionService;


import io.microservice.userservice.entities.Task;


import io.microservice.userservice.repositories.TaskRepository;
import io.microservice.userservice.repositories.UserrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ITaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserrRepository userrRepository;

    @Autowired
    SessionService sessionService;


    @Override
    public List<Task> getAllTaches()
    {
        return  (List<Task>) taskRepository.findAll();
    }


    @Override
    public Task getTachesById(Long id) {
        return   taskRepository.findById(id).get();
    }

    @Override
    public Task addTaches(Task t) {
        return taskRepository.save(t);
    }

    @Override
    public Task updateTaches(Task t) {
        return taskRepository.save(t);
    }

    @Override
    public void deleteTaches(Long id) {
        taskRepository.deleteById(id);
    }






    @Override
    public void deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId).orElse(null);

        if (task != null) {
            taskRepository.delete(task);
        }
    }



    @Override
    public List<Task> AllSessionTasks()
    {
        return taskRepository.findByUserToTask(sessionService.getUserBySession());
    }

}
