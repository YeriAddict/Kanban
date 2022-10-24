package leang.main.services;

import java.util.List;

import org.springframework.stereotype.Service;

import leang.main.entities.Developer;

@Service
public interface DevelopperService {
    
    public List<Developer> findAllDevelopers();
    
}
