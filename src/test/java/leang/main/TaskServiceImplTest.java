package leang.main;

import java.util.Collection;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import leang.main.entities.Task;
import leang.main.entities.TaskStatus;
import leang.main.entities.TaskType;
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
    
    @Test
    public void findAllTaskStatusTest() {
        Collection<TaskStatus> taskStatusListTest = this.taskService.findAllTaskStatus();
        Assert.assertEquals(4, taskStatusListTest.size(), 0);
        Assert.assertNotEquals(5, taskStatusListTest.size(), 0);
    }
    
    @Test
    public void findTaskStatusTest() {
        TaskStatus taskStatus = this.taskService.findTaskStatus(1);
        Assert.assertEquals("WORK_TO_DO", taskStatus.getLabel());
    }
    
    @Test
    public void findAllTaskTypesTest() {
        Collection<TaskType> taskTypeListTest = this.taskService.findAllTaskTypes();
        Assert.assertEquals(2, taskTypeListTest.size(), 0);
        Assert.assertNotEquals(3, taskTypeListTest.size(), 0);
    }
    
    @Test
    public void findTaskTypeTest() {
        TaskType taskType = this.taskService.findTaskType(1);
        Assert.assertEquals("FEATURE_TO_CREATE", taskType.getLabel());
    }
    
    @Test
    public void modifyLeftNewStatusTest() {
        String string = this.taskService.modifyLeftNewStatus(this.taskService.findTask(1));
        Assert.assertEquals("WORK_TO_DO", string);
    }
    
    @Test
    public void modifyRightNewStatusTest() {
        String string = this.taskService.modifyRightNewStatus(this.taskService.findTask(1));
        Assert.assertEquals("WORK_TO_TEST", string);
    }
    
    @Test
    public void changeStatusTest() {
        TaskStatus status = this.taskService.changeStatus("WORK_TO_TEST");
        Assert.assertEquals(3, status.getId(), 0);
    }
    
    @Test
    public void moveLeftTaskTest() {
        Task task = this.taskService.moveLeftTask(this.taskService.findTask(1));
        Assert.assertEquals("WORK_TO_DO", task.getTaskStatus().getLabel());
    }
    
    @Test
    public void moveRightTaskTest() {
        Task task = this.taskService.moveRightTask(this.taskService.findTask(1));
        Assert.assertEquals("WORK_TO_TEST", task.getTaskStatus().getLabel());
    }
}
