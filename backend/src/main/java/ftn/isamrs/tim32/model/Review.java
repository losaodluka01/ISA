package ftn.isamrs.tim32.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @ManyToOne
    private Account account;

    @ManyToOne
    private Airline airline;

    @ManyToOne
    private Flight flight;

    @Column
    private int score;

    @Column
    private int description;

    @Column
    private Date date;

    public Review(){

    }

    public Review(Account account, Airline airline, Flight flight, int score, int description, Date date) {
        this.account = account;
        this.airline = airline;
        this.flight = flight;
        this.score = score;
        this.description = description;
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
