package leang.main.services;

import java.util.List;

import org.springframework.stereotype.Service;

import leang.main.entities.Developer;
import leang.main.entities.Task;

@Service
public interface DeveloperService {
    
    public List<Developer> findAllDevelopers();
    public Developer findDeveloper(long id);
    
}
