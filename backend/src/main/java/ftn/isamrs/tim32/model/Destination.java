package ftn.isamrs.tim32.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Destination")
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(nullable= false)
    private String name;

    @ManyToMany
    private List<Airline> airline;

    @ManyToMany
    private List<Flight> flight;

    public Destination(){

    }

    public Destination(String name, List<Airline> airline) {
        this.name = name;
        this.airline = airline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Airline> getAirline() {
        return airline;
    }

    public void setAirline(List<Airline> airline) {
        this.airline = airline;
    }
}
