package leang.main.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "DEVELOPERS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Developer {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "developer_generator")
    @SequenceGenerator(name="developer_generator", sequenceName = "developer_sequence", allocationSize=50)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LAST_NAME")
    private String lastname;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "CONTRACT_START")
    private LocalDate startContract;
    
    public Developer() {
    }

    public Developer(String firstname, String lastname, String password, String email, LocalDate startContract) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.startContract = startContract;
    }
    
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getFirstname() {return firstname;}
    public void setFirstname(String firstname) {this.firstname = firstname;}

    public String getLastname() {return lastname;}
    public void setLastname(String lastname) {this.lastname = lastname;}
    
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public LocalDate getStartContract() {return startContract;}
    public void setStartContract(LocalDate startContract) {this.startContract = startContract;}
}
