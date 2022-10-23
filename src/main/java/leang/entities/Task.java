package leang.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "TASKS")
public class Task {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "NB_HOURS_FORECAST")
    private Integer nbHoursForecast;
    @Column(name = "NB_HOURS_REAL")
    private Integer nbHoursReal;
    @Column(name = "CREATION_DATE")
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
