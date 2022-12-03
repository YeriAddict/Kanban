package leang.main.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import leang.main.entities.Task;
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

}
