package ftn.isamrs.tim32.util;

import ftn.isamrs.tim32.dto.AirlineCreateDTO;
import ftn.isamrs.tim32.dto.FlightCreateDTO;
import ftn.isamrs.tim32.model.Airline;
import ftn.isamrs.tim32.model.Flight;
import org.modelmapper.ModelMapper;

public class ConvertDTOToModel {

    public ConvertDTOToModel(){

    }
    static ModelMapper mapper = new ModelMapper();

    public static Airline convertAirlineCreateToAirline(AirlineCreateDTO airline){
        return mapper.map(airline, Airline.class);
    }

    public static Flight convertFlightCreateToFlight(FlightCreateDTO flightCreate){
        return mapper.map(flightCreate, Flight.class);
    }

}
