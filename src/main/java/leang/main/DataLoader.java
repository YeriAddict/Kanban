package leang.main;

import java.time.LocalDate;
import java.time.Month;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import leang.entities.Developper;
import leang.repositories.ChangeLogRepository;
import leang.repositories.DevelopperRepository;
import leang.repositories.TaskRepository;
import leang.repositories.TaskStatusRepository;
import leang.repositories.TaskTypeRepository;

@Component
public class DataLoader implements CommandLineRunner {
    
    private DevelopperRepository developperRepository;
    
    public DataLoader(DevelopperRepository developperRepository) {
        this.developperRepository = developperRepository;
    }
    
    @Override
    public void run(String... strings) throws Exception {
        developperRepository.save(new Developper("Yerim", "Kim", "azerty", "a@gmail.com", LocalDate.of(2011, Month.NOVEMBER, 11)));
        developperRepository.save(new Developper("Park", "Sooyoung", "azerty", "b@gmail.com", LocalDate.of(2012, Month.DECEMBER, 12)));
    }
    
}
