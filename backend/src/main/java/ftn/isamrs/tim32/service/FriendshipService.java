package ftn.isamrs.tim32.service;

import ftn.isamrs.tim32.model.Friendship;

import java.util.List;

public interface FriendshipService {

    Friendship save(Friendship friendship);

    List<Friendship> findAllBySender(String username);

    List<Friendship> findAllByReceiver(String username);

    Friendship findBySenderAndReciever(String sender, String receiver);

    Boolean removeFriend(Long id);
}
