package ftn.isamrs.tim32.service;

import ftn.isamrs.tim32.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccountService {

    List<Account> findAll();

    Page<Account> findAll(Pageable page);

    Account findOne(Long id);

    Account findByUsername(String username);

    void checkUsername(String username);

    Account save(Account account);

    void remove(Long id);

    boolean isUsernameTaken(String username);

    //List<FlightReservation> findAllFlightReservation(long id);
    //List<HotelReservation> findAllHotelReservation(long id);
    //List<CarReservation> findAllCarReservation(long id);

    //List<ShowReservation> findAllReservations(long id);

    String findEmailById(Long id);

}
