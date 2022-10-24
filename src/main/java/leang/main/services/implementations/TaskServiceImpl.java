package leang.main.services.implementations;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leang.main.entities.Task;
import leang.main.entities.TaskStatus;
import leang.main.entities.TaskType;
import leang.main.repositories.TaskRepository;
import leang.main.repositories.TaskStatusRepository;
import leang.main.repositories.TaskTypeRepository;
import leang.main.services.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskStatusRepository taskStatusRepository;
    @Autowired
    private TaskTypeRepository taskTypeRepository;
    
    public Collection<Task> findAllTasks(){
        return this.taskRepository.findAll();
    }
    
    public Task findTask(long id) {
        return this.taskRepository.getReferenceById(id);
    }
    
    public Collection<TaskStatus> findAllTaskStatus(){
        return this.taskStatusRepository.findAll();
    }
    
    public TaskStatus findTaskStatus(long id) {
        return this.taskStatusRepository.getReferenceById(id);
    }
    
    public Collection<TaskType> findAllTaskTypes(){
        return this.taskTypeRepository.findAll();
    }
    
    public TaskType findTaskType(long id) {
        return this.taskTypeRepository.getReferenceById(id);
    }
    
    public Task moveRightTask(Task task) {
        return new Task();
    }

    public Task moveLeftTask(Task task) {
        return new Task();
    }
}
