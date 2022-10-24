package leang.main.services.implementations;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leang.main.entities.Task;
import leang.main.repositories.TaskRepository;
import leang.main.services.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    
    public Collection<Task> findAllTasks(){
        return this.taskRepository.findAll();
    }
    
    public Task findTask(long id) {
        return this.taskRepository.getReferenceById(id);
    }

}
