package leang.main;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import leang.main.repositories.DeveloperRepository;

@SpringBootTest
public class DeveloperRepositoryTest {

    @Autowired
    private DeveloperRepository developerRepository;
    
    @Test
    public void findAllTest() {
        Assert.assertEquals(5, this.developerRepository.findAll().size(), 0);
        Assert.assertNotEquals(6, this.developerRepository.findAll().size(), 0);
    }
    
}
