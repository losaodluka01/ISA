package ftn.isamrs.tim32.repository;

import ftn.isamrs.tim32.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query(value = "SELECT * FROM FLIGHT  f where f.name = :name and f.airline_id = :airline_id", nativeQuery = true)
    Flight findByNameAndAirlineId(@Param("name") String name, @Param("airline_id") Long airline_id);

    @Query(value = "SELECT * FROM FLIGHT  f where f.name = :name and f.description = :description", nativeQuery = true)
    Flight findByNameAndDescription(@Param("name") String name, @Param("description") String description);

    @Query(value="SELECT * from FLIGHT f where f.airline_id=:airline_id", nativeQuery = true)
    List<Flight> findByAirlineId(@Param("airline_id") Long airline_id);
}
