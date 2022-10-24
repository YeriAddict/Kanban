package leang.main;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
