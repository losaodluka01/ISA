package ftn.isamrs.tim32.controller;

import ftn.isamrs.tim32.dto.AirlineCreateDTO;
import ftn.isamrs.tim32.model.Airline;
import ftn.isamrs.tim32.service.AccountService;
import ftn.isamrs.tim32.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/airline")
public class AirlineController {

    @Autowired
    AirlineService airlineService;

    @Autowired
    AccountService accountService;


    @RequestMapping(value = "/get_all",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllAirlines(){
        List<Airline> airlineList = airlineService.findAll();
        ArrayList<AirlineCreateDTO> dtos = new ArrayList<>();

        for(Airline a : airlineList)
            dtos.add(new AirlineCreateDTO(a));

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

}
