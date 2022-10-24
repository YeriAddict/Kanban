package leang.main;


import org.springframework.boot.test.context.SpringBootTest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import leang.main.entities.Developer;
import leang.main.entities.Task;

@SpringBootTest
class TaskTest {
    @Test
    public void addDevelopperTest() {
        Developer developperTest = new Developer();
        Task taskTest = new Task();
        taskTest.addDeveloper(developperTest);
        Assert.assertEquals(1, taskTest.getDevelopers().size(),0);
        Assert.assertNotEquals(2, taskTest.getDevelopers().size(),0);
    }
}
