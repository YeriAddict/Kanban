package leang.main;

import java.util.Collection;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import leang.main.entities.Task;
import leang.main.services.TaskService;

@SpringBootTest
@Transactional
public class TaskServiceImplTest {

    @Autowired
    private TaskService taskService;
    
    @Test
    public void findAllTasksTest() {
        Collection<Task> developersListTest = this.taskService.findAllTasks();
        Assert.assertEquals(2, developersListTest.size(), 0);
        Assert.assertNotEquals(3, developersListTest.size(), 0);
    }
    
    @Test
    public void findTaskTest() {
        Task task = this.taskService.findTask(1);
        Assert.assertEquals("ReVe Festival 2022", task.getTitle());
    }
}
