package leang.main.services;

import java.util.Collection;

import leang.main.entities.Task;

public interface TaskService {

    public Collection<Task> findAllTasks();
    public Task findTask(long id);
}
