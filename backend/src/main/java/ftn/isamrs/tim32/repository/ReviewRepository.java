package ftn.isamrs.tim32.repository;

import ftn.isamrs.tim32.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository {

    Review findById(Long id);
}
