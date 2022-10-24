package leang.main.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "CHANGELOG")
public class ChangeLog {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "changelog_generator")
    @SequenceGenerator(name="changelog_generator", sequenceName = "changelog_sequence", allocationSize=50)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Column(name = "OCCURANCE_DATE")
    private LocalDate occured;
    @ManyToOne
    private Task task;
    @ManyToOne
    private TaskStatus sourceStatus;
    @ManyToOne
    private TaskStatus targetStatus;

    public ChangeLog() {
    }
    
    public ChangeLog(Long id, LocalDate occured) {
        this.id = id;
        this.occured = occured;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public LocalDate getOccured() {return occured;}
    public void setOccured(LocalDate occured) {this.occured = occured;}

    public Task getTask() {return task;}
    public void setTask(Task task) {this.task = task;}

    public TaskStatus getSourceStatus() {return sourceStatus;}
    public void setSourceStatus(TaskStatus sourceStatus) {this.sourceStatus = sourceStatus;}
    
    public TaskStatus getTargetStatus() {return targetStatus;}
    public void setTargetStatus(TaskStatus targetStatus) {this.targetStatus = targetStatus;}
}
