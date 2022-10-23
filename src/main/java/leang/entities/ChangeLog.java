package leang.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChangeLog {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private LocalDate occured;
    
    public ChangeLog() {
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public LocalDate getOccured() {return occured;}
    public void setOccured(LocalDate occured) {this.occured = occured;}
}
