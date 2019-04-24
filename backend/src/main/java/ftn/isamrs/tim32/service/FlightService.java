package ftn.isamrs.tim32.service;

import ftn.isamrs.tim32.dto.FlightCreateDTO;
import ftn.isamrs.tim32.model.Account;
import ftn.isamrs.tim32.model.Flight;


import java.util.List;

public interface FlightService {

    Flight save(FlightCreateDTO flightCreateDTO, Account user);

    void delete(FlightCreateDTO dto, Account user);

    void deleteFlight(FlightCreateDTO dto);

    Flight updateFlight(FlightCreateDTO dto);

    List<Flight> findAll();

    Flight findById(Long id);

    List<Flight> findByAirlineId(Long airline_id);


}
