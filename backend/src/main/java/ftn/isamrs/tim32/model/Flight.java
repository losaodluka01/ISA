package ftn.isamrs.tim32.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column
    private Date flightTakeoff;

    @Column
    private Date flightArrival;

    @Column
    private String timeElapsed;

    @Column
    private int numberOfStops;

    @Column
    private int price;

    @ManyToMany
    private List<Destination> flightRoute;

    @ManyToOne
    private Airline airline;

    @OneToMany(mappedBy = "flight")
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "flight")
    private List<Review> review;

    public Flight(){

    }

    public Flight(Date flightTakeoff, Date flightArrival, String timeElapsed, int numberOfStops, int price,
                  List<Destination> flightRoute, Airline airline, List<Ticket> tickets, List<Review> review) {
        this.flightTakeoff = flightTakeoff;
        this.flightArrival = flightArrival;
        this.timeElapsed = timeElapsed;
        this.numberOfStops = numberOfStops;
        this.price = price;
        this.flightRoute = flightRoute;
        this.airline = airline;
        this.tickets = tickets;
        this.review = review;
    }

    public Date getFlightTakeoff() {
        return flightTakeoff;
    }

    public void setFlightTakeoff(Date flightTakeoff) {
        this.flightTakeoff = flightTakeoff;
    }

    public Date getFlightArrival() {
        return flightArrival;
    }

    public void setFlightArrival(Date flightArrival) {
        this.flightArrival = flightArrival;
    }

    public String getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(String timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    public int getNumberOfStops() {
        return numberOfStops;
    }

    public void setNumberOfStops(int numberOfStops) {
        this.numberOfStops = numberOfStops;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Destination> getFlightRoute() {
        return flightRoute;
    }

    public void setFlightRoute(List<Destination> flightRoute) {
        this.flightRoute = flightRoute;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }
}
