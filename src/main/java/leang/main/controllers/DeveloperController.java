package leang.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import leang.main.entities.Developer;
import leang.main.services.DeveloperService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DeveloperController {
    
    @Autowired
    private DeveloperService developerService;
    
    @GetMapping("/developers")
    List<Developer> findAllDevelopers(){
        return developerService.findAllDevelopers();
    }
    
    @GetMapping("/developers/{id}")
    Developer findDeveloper(@PathVariable long id) {
        return developerService.findDeveloper(id);
    }
}
