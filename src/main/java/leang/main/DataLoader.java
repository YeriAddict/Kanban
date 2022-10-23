package leang.main;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import leang.main.entities.Developer;
import leang.main.repositories.ChangeLogRepository;
import leang.main.repositories.DeveloperRepository;
import leang.main.repositories.TaskRepository;
import leang.main.repositories.TaskStatusRepository;
import leang.main.repositories.TaskTypeRepository;

@Component
public class DataLoader implements CommandLineRunner {
    
    private DeveloperRepository developerRepository;
    private TaskRepository taskRepository;
    private TaskStatusRepository taskStatusRepository;
    private TaskTypeRepository taskTypeRepository;
    private ChangeLogRepository changeLogRepository;
    
    public DataLoader(DeveloperRepository developerRepository,
            TaskRepository taskRepository,
            TaskStatusRepository taskStatusRepository,
            TaskTypeRepository taskTypeRepository,
            ChangeLogRepository changeLogRepository) {
        this.developerRepository = developerRepository;
        this.taskRepository = taskRepository;
        this.taskStatusRepository = taskStatusRepository;
        this.taskTypeRepository = taskTypeRepository;
        this.changeLogRepository = changeLogRepository;
    }
    
    @Override
    public void run(String... strings) throws Exception {
        Developer irene = new Developer("Joo-hyun", "Bae", "Irene", "rv_irene@gmail.com", LocalDate.of(1991, Month.MARCH, 29));
        Developer seulgi = new Developer("Seul-gi", "Kang", "Seulgi", "rv_seulgi@gmail.com", LocalDate.of(1994, Month.FEBRUARY, 10));
        Developer wendy = new Developer("Seung-wan", "Son", "Wendy", "rv_wendy@gmail.com", LocalDate.of(1994, Month.FEBRUARY, 21));
        Developer joy = new Developer("Soo-young", "Park", "Joy", "rv_joy@gmail.com", LocalDate.of(1996, Month.SEPTEMBER, 3));
        Developer yeri = new Developer("Yerim", "Kim", "Yeri", "rv_yeri@gmail.com", LocalDate.of(1999, Month.MARCH, 5));
        
        developerRepository.save(irene);
        developerRepository.save(seulgi);
        developerRepository.save(wendy);
        developerRepository.save(joy);
        developerRepository.save(yeri);
    }
}
