package ftn.isamrs.tim32.repository;

import ftn.isamrs.tim32.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AirlineRepository extends JpaRepository<Airline, Long> {

    Airline findByAddressAndNameAndId(String address, String name, Long id);
}
