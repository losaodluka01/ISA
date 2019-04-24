package ftn.isamrs.tim32.repository;

import ftn.isamrs.tim32.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "SELECT * FROM REVIEW R WHERE R.ACCOUNT_ID = :accountId AND R.AIRLINE_ID = :airlineId", nativeQuery = true)
    Review alreadyReviewedAirline(@Param("accountId") Long accountId, @Param("airlineId") Long airlineId);

    @Query(value = "SELECT * FROM REVIEW R WHERE R.ACCOUNT_ID = :accountId AND R.FLIGHT_ID = :flightId", nativeQuery = true)
    Review alreadyReviewedFlight(@Param("accountId") Long accountId, @Param("flightId") Long flightId);

    @Query(value = "SELECT * FROM REVIEW R WHERE R.AIRLINE_ID = :airlineId", nativeQuery = true)
    List<Review> findByAiirlineId(@Param("airlineId") Long airlineId);

    @Query(value = "SELECT * FROM REVIEW R WHERE R.FLIGHT_ID = :flightId", nativeQuery = true)
    List<Review> findByFlightId(@Param("flightId")Long id);



}
