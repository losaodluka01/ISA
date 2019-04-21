package ftn.isamrs.tim32.service;

import ftn.isamrs.tim32.dto.AirlineCreateDTO;
import ftn.isamrs.tim32.model.Airline;

import java.util.List;

public interface AirlineService {

    Airline save(AirlineCreateDTO dto);

    List<Airline> findAll();

    void delete(AirlineCreateDTO airline);

    Airline findById(Long id);

    Airline updateAirline(AirlineCreateDTO dto);

    Airline save(Airline airline);


}
