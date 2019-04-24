package ftn.isamrs.tim32.controller;


import ftn.isamrs.tim32.dto.FlightCreateDTO;
import ftn.isamrs.tim32.model.Flight;
import ftn.isamrs.tim32.service.FlightService;
import org.hibernate.JDBCException;
import org.hibernate.dialect.lock.OptimisticEntityLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/flight")
public class FlightController {

    @Autowired
    FlightService flightService;

    @RequestMapping(value = "/get_all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllFlights() {
        List<Flight> flights = flightService.findAll();
        ArrayList<FlightCreateDTO> dtos = new ArrayList<>();

        for (Flight flight : flights)
            dtos.add(new FlightCreateDTO(flight));

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/get_flight",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getShowsByAirlineId(@RequestParam("id") Long airline_id) {

        List<Flight> flights = this.flightService.findByAirlineId(airline_id);

        List<FlightCreateDTO> dtos = new ArrayList<>();

        for (Flight flight : flights)
            dtos.add(new FlightCreateDTO(flight));

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/delete_flight",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteFlight(@RequestBody FlightCreateDTO flight)
    {
        try {

            flightService.deleteFlight(flight);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (OptimisticEntityLockException | NullPointerException | JDBCException e){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @Transactional
    @RequestMapping(value = "/update_flight",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateFlight(@RequestBody FlightCreateDTO dto){

        try {

            Flight flight = flightService.updateFlight(dto);

            if (flight == null) return new ResponseEntity(HttpStatus.NOT_FOUND);

            return new ResponseEntity<>(new FlightCreateDTO(flight), HttpStatus.OK);
        }
        catch (OptimisticEntityLockException | NullPointerException | JDBCException e){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

}
