package ftn.isamrs.tim32.model;

import ftn.isamrs.tim32.model.enumeration.FriendshipStatus;

import javax.persistence.*;

@Entity
@Table(name= "friendship")
@Inheritance(strategy = InheritanceType.JOINED)
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @OneToOne
    private Account sender;

    @OneToOne
    private Account receiver;

    @Column
    private FriendshipStatus friendshipStatus;

    public Friendship(){

    }

    public Friendship(Account sender, Account receiver, FriendshipStatus friendshipStatus) {
        this.sender = sender;
        this.receiver = receiver;
        this.friendshipStatus = friendshipStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getSender() {
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public void setReceiver(Account receiver) {
        this.receiver = receiver;
    }

    public FriendshipStatus getFriendshipStatus() {
        return friendshipStatus;
    }

    public void setFriendshipStatus(FriendshipStatus friendshipStatus) {
        this.friendshipStatus = friendshipStatus;
    }
}
