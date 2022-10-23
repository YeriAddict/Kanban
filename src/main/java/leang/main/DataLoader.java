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
        Developper irene = new Developper("Joo-hyun", "Bae", "Irene", "rv_irene@gmail.com", LocalDate.of(1991, Month.MARCH, 29));
        Developper seulgi = new Developper("Seul-gi", "Kang", "Seulgi", "rv_seulgi@gmail.com", LocalDate.of(1994, Month.FEBRUARY, 10));
        Developper wendy = new Developper("Seung-wan", "Son", "Wendy", "rv_wendy@gmail.com", LocalDate.of(1994, Month.FEBRUARY, 21));
        Developper joy = new Developper("Soo-young", "Park", "Joy", "rv_joy@gmail.com", LocalDate.of(1996, Month.SEPTEMBER, 3));
        Developper yeri = new Developper("Yerim", "Kim", "Yeri", "rv_yeri@gmail.com", LocalDate.of(1999, Month.MARCH, 5));
        
        developperRepository.save(irene);
        developperRepository.save(seulgi);
        developperRepository.save(wendy);
        developperRepository.save(joy);
        developperRepository.save(yeri);
    }
}
