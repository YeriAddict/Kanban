package leang.main.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import leang.main.entities.Task;
import leang.main.entities.TaskStatus;
import leang.main.entities.TaskType;
import leang.main.services.TaskService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TaskController {
    
    @Autowired
    private TaskService taskService;
    
    @GetMapping("/tasks")
    Collection<Task> findAllTasks(){
        return taskService.findAllTasks();
    }
    
    @GetMapping("/task_status")
    Collection<TaskStatus> findAllTaskStatus(){
        return taskService.findAllTaskStatus();
    }
    
    @GetMapping("/task_types")
    Collection<TaskType> findAllTaskTypes(){
        return taskService.findAllTaskTypes();
    }

    @PostMapping("/tasks" )
    Task createTask(@RequestBody Task task) {
        return this.taskService.createTask(task);
    }
    
}
