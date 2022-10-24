package leang.main.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.GenericGenerator;

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

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getLabel() {return label;}
    public void setLabel(String label) {this.label = label;}
}
