package ftn.isamrs.tim32.service;

import ftn.isamrs.tim32.model.Review;

import java.util.List;

public interface ReviewService {

    boolean alreadyReviewedAirline(Long accountId, Long airlineId);

    boolean alreadyReviewedFlight(Long accountId, Long FlightId);

    Review save (Review review);

    List<Review> findByAirlineId(Long airlineId);

    List<Review> findByFlightId(Long id);
}
