package leang.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    private Integer nbHoursForecast;
    private Integer nbHoursReal;
    private LocalDate created;
    
    public Task() {
    }
    
    public Task(Long id, String title, Integer nbHoursForecast, Integer nbHoursReal, LocalDate created) {
        this.id = id;
        this.title = title;
        this.nbHoursForecast = nbHoursForecast;
        this.nbHoursReal = nbHoursReal;
        this.created = created;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public Integer getNbHoursForecast() {return nbHoursForecast;}
    public void setNbHoursForecast(Integer nbHoursForecast) {this.nbHoursForecast = nbHoursForecast;}

    public Integer getNbHoursReal() {return nbHoursReal;}
    public void setNbHoursReal(Integer nbHoursReal) {this.nbHoursReal = nbHoursReal;}

    public LocalDate getCreated() {return created;}
    public void setCreated(LocalDate created) {this.created = created;}
}
