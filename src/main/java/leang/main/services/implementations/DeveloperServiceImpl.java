package leang.main.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leang.main.entities.Developer;
import leang.main.repositories.DeveloperRepository;

@Service
public class DeveloperServiceImpl {
    
    @Autowired
    private DeveloperRepository developerRepository;
    
    public List<Developer> findAllDevelopers(){
        return this.developerRepository.findAll();
    }
}
