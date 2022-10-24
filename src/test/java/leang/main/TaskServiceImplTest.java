package leang.main;

import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import leang.main.entities.Developer;
import leang.main.entities.Task;
import leang.main.repositories.TaskRepository;
import leang.main.services.TaskService;

@SpringBootTest
public class TaskServiceImplTest {

    @Autowired
    private TaskService taskService;
    
    @Test
    public void findAllDevelopersTest() {
        Collection<Task> developersListTest = this.taskService.findAllTasks();
        Assert.assertEquals(2, developersListTest.size(), 0);
        Assert.assertNotEquals(3, developersListTest.size(), 0);
    }
}
