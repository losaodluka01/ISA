package ftn.isamrs.tim32.repository;

import ftn.isamrs.tim32.model.Account;
import ftn.isamrs.tim32.model.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {

    List<Friendship> findAllBySender(Account sender);

    List<Friendship> findAllByReceiver(Account receiver);

    Friendship findBySenderAndReceiver(Account sender, Account Receiver);

    Optional<Friendship> findById(Long id);

}
