package leang.main.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "TASK_STATUS")
public class TaskStatus {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "taskstatus_generator")
    @SequenceGenerator(name="taskstatus_generator", sequenceName = "taskstatus_sequence", allocationSize=50)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Column(name = "LABEL")
    private String label;
    
    public TaskStatus() {
        
    }
    
    public TaskStatus(Long id, String label) {
        this.id = id;
        this.label = label;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getLabel() {return label;}
    public void setLabel(String label) {this.label = label;}
}
