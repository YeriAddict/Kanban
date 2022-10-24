package leang.main;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import leang.main.entities.Developer;
import leang.main.entities.Task;
import leang.main.entities.TaskStatus;
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
        
        Task task_one = new Task("ReVe Festival 2022", 0, 0, LocalDate.of(2022, Month.MARCH, 22));
        Task task_two = new Task("Queendom 2021", 0, 0, LocalDate.of(2021, Month.AUGUST, 21));
        taskRepository.save(task_one);
        taskRepository.save(task_two);
        
        TaskStatus status_one = new TaskStatus("WORK_TO_DO");
        TaskStatus status_two = new TaskStatus("WORK_ON_PROGRESS");
        TaskStatus status_three = new TaskStatus("WORK_TO_TEST");
        TaskStatus status_four = new TaskStatus("WORK_DONE");
        taskStatusRepository.save(status_one);
        taskStatusRepository.save(status_two);
        taskStatusRepository.save(status_three);
        taskStatusRepository.save(status_four);
    }
}
