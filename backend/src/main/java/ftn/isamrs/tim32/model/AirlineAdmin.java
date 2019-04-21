package ftn.isamrs.tim32.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "Airline_Admin")
public class AirlineAdmin extends Account {

    @ManyToOne
    @JsonBackReference
    Airline airline;

    @Column
    private boolean changedPassword;

    public AirlineAdmin(){

    }

    public AirlineAdmin(Airline airline, boolean changedPassword) {
        this.airline = airline;
        this.changedPassword = changedPassword;
    }

    public AirlineAdmin(String name, String lastname, boolean confirmed, String username, String password, String email, Airline airline, boolean changedPassword) {
        super(name, lastname, confirmed, username, password, email);
        this.airline = airline;
        this.changedPassword = changedPassword;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public boolean isChangedPassword() {
        return changedPassword;
    }

    public void setChangedPassword(boolean changedPassword) {
        this.changedPassword = changedPassword;
    }
}
