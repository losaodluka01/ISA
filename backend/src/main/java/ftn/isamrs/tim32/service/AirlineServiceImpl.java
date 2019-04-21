package ftn.isamrs.tim32.service;

import ftn.isamrs.tim32.dto.AirlineCreateDTO;
import ftn.isamrs.tim32.model.Airline;
import ftn.isamrs.tim32.repository.AirlineRepository;
import ftn.isamrs.tim32.util.ConvertDTOToModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineServiceImpl implements AirlineService {

    @Autowired
    private AirlineRepository airlineRepository;

    @Override
    public Airline save(AirlineCreateDTO dto){

        Airline airline = ConvertDTOToModel.convertAirlineCreateToAirline(dto);
        airline = airlineRepository.save(airline);
        return airline;
    }

    @Override
    public List<Airline> findAll() { return airlineRepository.findAll();}

    @Override
    public void delete(AirlineCreateDTO dto){
        Optional<Airline> airline = airlineRepository.findById(dto.getId());
        if(!airline.isPresent()) return;
        airlineRepository.delete(airline.get());
    }

    @Override
    public Airline findById(Long id){
        Optional<Airline> airline = this.airlineRepository.findById(id);
        return airline.orElse(null);
    }

    @Override
    public Airline updateAirline(AirlineCreateDTO dto){
        Optional<Airline> air = airlineRepository.findById(dto.getId());

        if(!air.isPresent()) return null;

        Airline airline = air.get();

        airline.setAddress(dto.getAddress());
        airline.setName(dto.getName());

        airline = airlineRepository.save(airline);

        return airline;
    }

    @Override
    public Airline save(Airline airline) {return airlineRepository.save(airline);}
}
