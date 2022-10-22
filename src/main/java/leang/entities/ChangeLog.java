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
}
