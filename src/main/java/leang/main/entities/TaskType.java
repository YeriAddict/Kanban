package leang.main.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "TASK_TYPE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TaskType {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "tasktype_generator")
    @SequenceGenerator(name="tasktype_generator", sequenceName = "tasktype_sequence", allocationSize=50)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Column(name = "LABEL")
    private String label;
    
    public TaskType() {
        
    }
    
    public TaskType(Long id, String label) {
        this.id = id;
        this.label = label;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getLabel() {return label;}
    public void setLabel(String label) {this.label = label;}
}
