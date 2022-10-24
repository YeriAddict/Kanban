package leang.main.services;

import java.util.Collection;

import leang.main.entities.Task;
import leang.main.entities.TaskStatus;
import leang.main.entities.TaskType;

public interface TaskService {

    public Collection<Task> findAllTasks();
    public Task findTask(long id);
    public Collection<TaskStatus> findAllTaskStatus();
    public TaskStatus findTaskStatus(long id);
    public Collection<TaskType> findAllTaskTypes();
    public TaskType findTaskType(long id);
    public String modifyLeftNewStatus(Task task);
    public String modifyRightNewStatus(Task task);
    public TaskStatus changeStatus(String newStatus);
    public Task changeTask(Task task, TaskStatus outputStatus);
    public Task moveLeftTask(Task task);
    public Task moveRightTask(Task task);
    
}
