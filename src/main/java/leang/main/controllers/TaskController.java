package leang.main.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping("/tasks/{id}")
    Task findTask(@PathVariable long id) {
        return taskService.findTask(id);
    }
    
    @GetMapping("/task_status")
    Collection<TaskStatus> findAllTaskStatus(){
        return taskService.findAllTaskStatus();
    }
    
    @GetMapping("/task_status/{id}")
    TaskStatus findTaskStatus(@PathVariable long id) {
        return taskService.findTaskStatus(id);
    }
    
    @GetMapping("/task_types")
    Collection<TaskType> findAllTaskTypes(){
        return taskService.findAllTaskTypes();
    }
    
    @GetMapping("/task_types/{id}")
    TaskType findTaskType(@PathVariable long id) {
        return taskService.findTaskType(id);
    }

    @PostMapping("/tasks" )
    Task createTask(@RequestBody Task task) {
        return this.taskService.createTask(task);
    }
    
    @PatchMapping("/tasks/{id}")
    Task moveTask(@RequestBody String instruction, @PathVariable long id) {
        Task task = taskService.findTask(id);
        
        if(instruction.equals("LEFT")) {
            task = this.taskService.moveLeftTask(task);
        }
        else if(instruction.equals("RIGHT")) {
            task = this.taskService.moveRightTask(task);
        }
        else{
            throw new IllegalStateException();
        }
        
        return task;
    }
}
