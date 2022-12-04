package leang.main.services.implementations;

import java.time.LocalDate;
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
import leang.main.structs.Status;

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
    
    public String modifyLeftNewStatus(Task task) {
        String newStatus = "";
        
        if (task.getTaskStatus().getLabel().equals(Status.STATUS_TWO_LABEL)) {
            newStatus = Status.STATUS_ONE_LABEL;
        }
        else if (task.getTaskStatus().getLabel().equals(Status.STATUS_THREE_LABEL)){
            newStatus = Status.STATUS_TWO_LABEL;
        }
        else if (task.getTaskStatus().getLabel().equals(Status.STATUS_FOUR_LABEL)){
            newStatus = Status.STATUS_THREE_LABEL;
        }
        else {
            throw new IllegalStateException();
        }
        return newStatus;
    }
    
    public String modifyRightNewStatus(Task task) {
        String newStatus = "";
        
        if (task.getTaskStatus().getLabel().equals(Status.STATUS_ONE_LABEL)) {
            newStatus = Status.STATUS_TWO_LABEL;
        }
        else if (task.getTaskStatus().getLabel().equals(Status.STATUS_TWO_LABEL)){
            newStatus = Status.STATUS_THREE_LABEL;
        }
        else if (task.getTaskStatus().getLabel().equals(Status.STATUS_THREE_LABEL)){
            newStatus = Status.STATUS_FOUR_LABEL;
        }
        else {
            throw new IllegalStateException();
        }
        return newStatus;
    }
    
    public TaskStatus changeStatus(String newStatus) {
        TaskStatus outputStatus = null;
        
        if(newStatus.equals(Status.STATUS_ONE_LABEL)) {
            outputStatus = this.findTaskStatus(Status.STATUS_ONE_ID);
        }
        else if(newStatus.equals(Status.STATUS_TWO_LABEL)) {
            outputStatus = this.findTaskStatus(Status.STATUS_TWO_ID);
        }
        else if (newStatus.equals(Status.STATUS_THREE_LABEL)) {
            outputStatus = this.findTaskStatus(Status.STATUS_THREE_ID);
        }
        else {
            outputStatus = this.findTaskStatus(Status.STATUS_FOUR_ID);
        }
        return outputStatus;
    }
    
    public Task changeTask(Task task, TaskStatus outputStatus) {
        task.setTaskStatus(outputStatus);
        task = this.taskRepository.save(task);
        return task;
    }
    
    public Task moveLeftTask(Task task) {
        TaskStatus targetStatus = this.changeStatus(modifyLeftNewStatus(task));
        return this.changeTask(task, targetStatus);
    }
    
    public Task moveRightTask(Task task) {
        TaskStatus targetStatus = this.changeStatus(modifyRightNewStatus(task));
        return this.changeTask(task, targetStatus);
    }
    
    public Task createTask(Task task) {
        TaskStatus status = this.findTaskStatus(Status.STATUS_ONE_ID);
        task.setTaskStatus(status);
        task.setCreated(LocalDate.now());
        return this.taskRepository.save(task);
    }
}
