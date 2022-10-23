package leang.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "TASK_STATUS")
public class TaskStatus {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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
