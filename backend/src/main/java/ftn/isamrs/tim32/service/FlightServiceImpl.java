package ftn.isamrs.tim32.service;

import ftn.isamrs.tim32.dto.FlightCreateDTO;
import ftn.isamrs.tim32.model.Account;
import ftn.isamrs.tim32.model.AirlineAdmin;
import ftn.isamrs.tim32.model.Flight;
import ftn.isamrs.tim32.repository.FlightRepository;
import ftn.isamrs.tim32.util.ConvertDTOToModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService{

    @Autowired
    FlightRepository flightRepository;

    @Override
    public Flight save(FlightCreateDTO flightCreateDTO, Account user){

        Flight flight = ConvertDTOToModel.convertFlightCreateToFlight(flightCreateDTO);
        flight.setAirline(((AirlineAdmin)user).getAirline());
        return flightRepository.save(flight);

    }

    @Override
    public void delete(FlightCreateDTO dto, Account user){
        flightRepository.findByNameAndAirlineId(dto.getDescription(), ((AirlineAdmin)user).getAirline().getId() );

    }

    @Override
    public void deleteFlight(FlightCreateDTO dto){
        Optional<Flight> flight = flightRepository.findById(dto.getId());
        if(!flight.isPresent()) return;
        flightRepository.delete(flight.get());

    }

    @Override
    public Flight updateFlight(FlightCreateDTO dto){
        Optional<Flight> f = this.flightRepository.findById(dto.getId());
        if(!f.isPresent()) return null;

        Flight flight = f.get();

        flight.setFlightArrival(dto.getFlightArrival());
        flight.setFlightTakeoff(dto.getFlightTakeoff());
        flight.setFlightArrival(dto.getFlightArrival());
        flight.setDescription(dto.getDescription());
        flight.setPrice(dto.getPrice());

        flight = flightRepository.save(flight);

        return flight;
    }

    @Override
    public List<Flight> findAll() { return flightRepository.findAll(); }

    @Override
    public Flight findById(Long id){
        Optional<Flight> flight = this.flightRepository.findById(id);
        return flight.orElse(null);
    }

    @Override
    public List<Flight> findByAirlineId(Long airline_id){
        List<Flight> flights = this.flightRepository.findByAirlineId(airline_id);
        return flights;
    }

}
