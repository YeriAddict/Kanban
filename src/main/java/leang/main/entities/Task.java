package leang.main.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "TASKS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Task {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "task_generator")
    @SequenceGenerator(name="task_generator", sequenceName = "task_sequence", allocationSize=50)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Column(name = "TITLE")
    @NotNull(message = "Title cannot be null")
    @NotEmpty(message = "Title cannot be empty")
    @Size(min = 1, max = 30, message = "must be between 1 and 30 characters")
    private String title;
    @Column(name = "NB_HOURS_FORECAST")
    @NotNull(message = "nbHoursForecast cannot be null")
    @Min(value = 0, message = "nbHoursForecast should not be less than 0")
    @Max(value = 200, message = "nbHoursForecast should not be greater than 200")
    private Integer nbHoursForecast;
    @Column(name = "NB_HOURS_REAL")
    @NotNull(message = "nbHoursReal cannot be null")
    @Min(value = 0, message = "nbHoursReal should not be less than 0")
    @Max(value = 200, message = "nbHoursReal should not be greater than 200")
    private Integer nbHoursReal;
    @Column(name = "CREATION_DATE")
    private LocalDate created;
    @ManyToMany
    @NotEmpty(message = "developers cannot be empty")
    private Set<Developer> developers;
    @ManyToOne
    private TaskStatus taskStatus;
    @ManyToOne
    private TaskType taskType;
    
    public Task() {
        this.developers = new HashSet<>();
    }
    
    public Task(String title, Integer nbHoursForecast, Integer nbHoursReal, LocalDate created) {
        this.developers = new HashSet<>();
        this.title = title;
        this.nbHoursForecast = nbHoursForecast;
        this.nbHoursReal = nbHoursReal;
        this.created = created;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public Integer getNbHoursForecast() {return nbHoursForecast;}
    public void setNbHoursForecast(Integer nbHoursForecast) {this.nbHoursForecast = nbHoursForecast;}

    public Integer getNbHoursReal() {return nbHoursReal;}
    public void setNbHoursReal(Integer nbHoursReal) {this.nbHoursReal = nbHoursReal;}

    public LocalDate getCreated() {return created;}
    public void setCreated(LocalDate created) {this.created = created;}
    
    public Set<Developer> getDevelopers() {return developers;}
    public void setDevelopers(Set<Developer> developers) {this.developers = developers;}
    
    public TaskStatus getTaskStatus() {return taskStatus;}
    public void setTaskStatus(TaskStatus taskStatus) {this.taskStatus = taskStatus;}

    public TaskType getTaskType() {return taskType;}
    public void setTaskType(TaskType taskType) {this.taskType = taskType;}
    
    public void addDeveloper(Developer developer) {
        this.developers.add(developer);
    }

}
