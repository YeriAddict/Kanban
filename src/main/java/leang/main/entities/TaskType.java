package leang.main.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "TASK_TYPE")
public class TaskType {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "ID")
    private Long id;
    @Column(name = "LABEL")
    private String label;
    
    public TaskType() {
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getLabel() {return label;}
    public void setLabel(String label) {this.label = label;}
}