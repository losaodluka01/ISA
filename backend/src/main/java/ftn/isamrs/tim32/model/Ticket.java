package ftn.isamrs.tim32.model;

import javax.persistence.*;

@Entity
@Table(name = "Ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @ManyToOne
    private Account account;

    @ManyToOne
    private Flight flight;

    @ManyToOne
    private Airline airline;

    @Column
    private int price;

    public Ticket(){

    }

    public Ticket(Account account, Flight flight, Airline airline, int price) {
        this.account = account;
        this.flight = flight;
        this.airline = airline;
        this.price = price;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
