package leang.main;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import leang.main.entities.Developper;
import leang.main.repositories.ChangeLogRepository;
import leang.main.repositories.DevelopperRepository;
import leang.main.repositories.TaskRepository;
import leang.main.repositories.TaskStatusRepository;
import leang.main.repositories.TaskTypeRepository;

@Component
public class DataLoader implements CommandLineRunner {
    
    private DevelopperRepository developperRepository;
    private TaskRepository taskRepository;
    private TaskStatusRepository taskStatusRepository;
    private TaskTypeRepository taskTypeRepository;
    private ChangeLogRepository changeLogRepository;
    
    public DataLoader(DevelopperRepository developperRepository,
            TaskRepository taskRepository,
            TaskStatusRepository taskStatusRepository,
            TaskTypeRepository taskTypeRepository,
            ChangeLogRepository changeLogRepository) {
        this.developperRepository = developperRepository;
        this.taskRepository = taskRepository;
        this.taskStatusRepository = taskStatusRepository;
        this.taskTypeRepository = taskTypeRepository;
        this.changeLogRepository = changeLogRepository;
    }
    
    @Override
    public void run(String... strings) throws Exception {
        developperRepository.save(new Developper("Yerim", "Kim", "azerty", "a@gmail.com", LocalDate.of(2011, Month.NOVEMBER, 11)));
        developperRepository.save(new Developper("Park", "Sooyoung", "azerty", "b@gmail.com", LocalDate.of(2012, Month.DECEMBER, 12)));
    }
    
}
