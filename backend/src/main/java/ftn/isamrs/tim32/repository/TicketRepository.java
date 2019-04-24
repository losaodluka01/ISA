package ftn.isamrs.tim32.repository;

import ftn.isamrs.tim32.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository {

    Ticket findById(Long id);

}
