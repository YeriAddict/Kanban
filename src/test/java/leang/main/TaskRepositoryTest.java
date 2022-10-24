package leang.main;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import leang.main.entities.Task;
import leang.main.repositories.TaskRepository;

@SpringBootTest
public class TaskRepositoryTest {
    @Autowired
    private TaskRepository taskRepository;
    
    @Test
    public void findAllTest() {
        Assert.assertEquals(2, this.taskRepository.findAll().size(), 0);
        Assert.assertNotEquals(3, this.taskRepository.findAll().size(), 0);
    }
    
    @Test 
    public void saveTest() {
        Task task_three = new Task("Queendom", 0, 0, LocalDate.of(2021, Month.AUGUST, 21)); 
        this.taskRepository.save(task_three);
        Assert.assertEquals(3, this.taskRepository.findAll().size(), 0);
        Assert.assertNotEquals(4, this.taskRepository.findAll().size(), 0);
        this.taskRepository.delete(task_three);
    }
}
