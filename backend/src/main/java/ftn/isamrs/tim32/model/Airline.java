package ftn.isamrs.tim32.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.List;

@Entity
@Table(name = "Airline")
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String address;

    @Column(nullable = false)
    String opis;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "Airline", cascade = CascadeType.REMOVE)
    List<Destination> destinationList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Airline", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    List<Flight> flightList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Airline", cascade = CascadeType.REMOVE)
    List<Ticket> discountedTickets;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Airline", cascade = CascadeType.REMOVE)
    List<Review> reviewList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Airline", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    List<AirlineAdmin> airlineAdminList;


    public Airline(){

    }

    public Airline(String name, String address, String opis, List<Destination> destinationList, List<Flight> flightList, List<Ticket> discountedTickets) {
        this.name = name;
        this.address = address;
        this.opis = opis;
        this.destinationList = destinationList;
        this.flightList = flightList;
        this.discountedTickets = discountedTickets;
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

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public List<Destination> getDestinationList() {
        return destinationList;
    }

    public void setDestinationList(List<Destination> destinationList) {
        this.destinationList = destinationList;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public List<Ticket> getDiscountedTickets() {
        return discountedTickets;
    }

    public void setDiscountedTickets(List<Ticket> discountedTickets) {
        this.discountedTickets = discountedTickets;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public List<AirlineAdmin> getAirlineAdminList() {
        return airlineAdminList;
    }

    public void setAirlineAdminList(List<AirlineAdmin> airlineAdminList) {
        this.airlineAdminList = airlineAdminList;
    }
}
