package ftn.isamrs.tim32.repository;

import ftn.isamrs.tim32.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository {

    Destination findByName (String name);

}
