package ftn.isamrs.tim32.repository;

import ftn.isamrs.tim32.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository {

    Flight findById(Long id);

}
