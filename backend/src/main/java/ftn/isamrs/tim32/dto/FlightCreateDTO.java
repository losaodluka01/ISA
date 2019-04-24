package ftn.isamrs.tim32.dto;

import ftn.isamrs.tim32.model.Destination;
import ftn.isamrs.tim32.model.Flight;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class FlightCreateDTO implements Serializable {

    private Long id;
    private String description;
    private Date flightTakeoff;
    private Date flightArrival;
    private String timeElapsed;
    private int numberOfStops;
    private int price;
    private List<Destination> flightRoute;

    public FlightCreateDTO(){

    }

    public FlightCreateDTO(String description, Date flightTakeoff, Date flightArrival,
                           String timeElapsed, int numberOfStops, int price, List<Destination> flightRoute) {
        this.description = description;
        this.flightTakeoff = flightTakeoff;
        this.flightArrival = flightArrival;
        this.timeElapsed = timeElapsed;
        this.numberOfStops = numberOfStops;
        this.price = price;
        this.flightRoute = flightRoute;
    }

    public FlightCreateDTO(Flight flight){

        this.description=flight.getDescription();
        this.flightTakeoff=flight.getFlightTakeoff();
        this.flightArrival=flight.getFlightArrival();
        this.timeElapsed=flight.getTimeElapsed();
        this.numberOfStops=flight.getNumberOfStops();
        this.price=flight.getPrice();
        this.flightRoute=flight.getFlightRoute();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
