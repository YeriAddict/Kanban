package leang.main.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import leang.main.entities.Task;

@Service
public interface TaskService {

    public Collection<Task> findAllTasks();
    public Task findTask(long id);
    public Task moveRightTask(Task task);
    public Task moveLeftTask(Task task);
    
}
