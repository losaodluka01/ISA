package ftn.isamrs.tim32.controller;

import ftn.isamrs.tim32.dto.AirlineCreateDTO;
import ftn.isamrs.tim32.model.Flight;
import ftn.isamrs.tim32.service.AccountService;
import ftn.isamrs.tim32.service.AirlineService;
import ftn.isamrs.tim32.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/admin")
@CrossOrigin(value = "http://localhost:4200")
public class AdminController {

    @Autowired
    AirlineService airlineService;

    @Autowired
    FlightService flightService;

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/create_airline",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createAirline(@RequestBody AirlineCreateDTO airline)
    {
        return new ResponseEntity<>(airlineService.save(airline), HttpStatus.CREATED);
    }
}
