package ftn.isamrs.tim32.service;

import ftn.isamrs.tim32.model.Review;
import ftn.isamrs.tim32.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public boolean alreadyReviewedAirline(Long accountId, Long airlineId){

        return this.reviewRepository.alreadyReviewedAirline(accountId, airlineId) == null;
    }

    @Override
    public boolean alreadyReviewedFlight(Long accountId, Long flightId){

        return this.reviewRepository.alreadyReviewedFlight(accountId, flightId) == null;
    }

    @Override
    public Review save(Review review){ return this.reviewRepository.save(review); }

    @Override
    public List<Review> findByAirlineId(Long airlineId){ return this.reviewRepository.findByAiirlineId(airlineId);}

    @Override
    public List<Review> findByFlightId(Long flightId){ return this.reviewRepository.findByFlightId(flightId);}

}
