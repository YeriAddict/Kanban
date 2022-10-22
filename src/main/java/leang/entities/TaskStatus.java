package leang.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TaskStatus {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String label;
    
    public TaskStatus() {
    }
}
