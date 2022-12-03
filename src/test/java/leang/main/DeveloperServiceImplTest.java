package leang.main;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import leang.main.entities.Developer;
import leang.main.services.DeveloperService;

@SpringBootTest
public class DeveloperServiceImplTest {

    @Autowired
    private DeveloperService developerService;
    
    @Test
    public void findAllDevelopersTest() {
        List<Developer> developersListTest = this.developerService.findAllDevelopers();
        Assert.assertEquals(5, developersListTest.size(), 0);
        Assert.assertNotEquals(6, developersListTest.size(), 0);
    }
    
}
