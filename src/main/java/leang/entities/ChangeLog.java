package leang.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChangeLog {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Date occured;
    
    public ChangeLog() {
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public Date getOccured() {return occured;}
    public void setOccured(Date occured) {this.occured = occured;}
}
