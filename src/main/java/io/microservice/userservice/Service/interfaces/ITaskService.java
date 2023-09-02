package io.microservice.userservice.Service.interfaces;


import io.microservice.userservice.entities.Task;

import java.util.List;

public interface ITaskService {


    List<Task> getAllTaches();

    Task getTachesById (Long id);

    Task addTaches (Task t);

    Task updateTaches (Task t);

    void deleteTaches (Long id);



    public void deleteTask(Long taskId);


    public List<Task> AllSessionTasks();

}
