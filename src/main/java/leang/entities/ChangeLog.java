package leang.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "CHANGELOG")
public class ChangeLog {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "ID")
    private Long id;
    @Column(name = "OCCURANCE_DATE")
    private LocalDate occured;
    
    public ChangeLog() {
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public LocalDate getOccured() {return occured;}
    public void setOccured(LocalDate occured) {this.occured = occured;}
}
