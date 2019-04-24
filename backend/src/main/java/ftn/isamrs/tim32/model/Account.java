package ftn.isamrs.tim32.model;

import ftn.isamrs.tim32.model.enumeration.AccountLevel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account")
@Inheritance(strategy = InheritanceType.JOINED)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false, columnDefinition = "BOOL DEFAULT FALSE")
    private boolean confirmed;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "account", cascade = CascadeType.REMOVE)
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "account", cascade = CascadeType.REMOVE)
    private List<Review> reviews;

    @Column
    private AccountLevel accountLevel;

    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private int points;

    public Account(){

    }
    public Account(String name, String lastname, boolean confirmed, String username, String password, String email,
                   List<Ticket> tickets, List<Review> reviews, AccountLevel accountLevel, int points) {
        this.name = name;
        this.lastname = lastname;
        this.confirmed = confirmed;
        this.username = username;
        this.password = password;
        this.email = email;
        this.tickets = tickets;
        this.reviews = reviews;
        this.accountLevel = accountLevel;
        this.points = points;
    }

    public void updateLevel(List<Integer> scale) {
        if(this.points > scale.get(3))
            this.setAccountLevel(AccountLevel.PLATINUM);
        else if (this.points > scale.get(2))
            this.setAccountLevel(AccountLevel.GOLD);
        else if (this.points > scale.get(1))
            this.setAccountLevel(AccountLevel.SILVER);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public AccountLevel getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(AccountLevel accountLevel) {
        this.accountLevel = accountLevel;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

}
