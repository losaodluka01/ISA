package ftn.isamrs.tim32.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "airline")
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = true)
    private String description;

    @ManyToMany(mappedBy = "airline", cascade = CascadeType.REMOVE)
    private List<Destination> destinations;

    @OneToMany(mappedBy = "airline", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Flight> flights;

    @OneToMany(mappedBy = "airline", cascade = CascadeType.REMOVE)
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "airline", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<AirlineAdmin> airlineAdmins;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "airline", cascade = CascadeType.REMOVE)
    private List<Review> review;

    public Airline(){

    }
    public Airline(String name, String address, String description, List<Destination> destinations, List<Flight> flights,
                   List<Ticket> tickets, List<AirlineAdmin> airlineAdmins, List<Review> review) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.destinations = destinations;
        this.flights = flights;
        this.tickets = tickets;
        this.airlineAdmins = airlineAdmins;
        this.review = review;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<AirlineAdmin> getAirlineAdmins() {
        return airlineAdmins;
    }

    public void setAirlineAdmins(List<AirlineAdmin> airlineAdmins) {
        this.airlineAdmins = airlineAdmins;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
