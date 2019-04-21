package ftn.isamrs.tim32.dto;

import ftn.isamrs.tim32.model.Airline;

import java.io.Serializable;

public class AirlineCreateDTO implements Serializable {

    private Long id;
    private String name;
    private String address;

    public AirlineCreateDTO(String name, String address){
        this.name = name;
        this.address = address;
    }

    public AirlineCreateDTO(){

    }

    public AirlineCreateDTO(Airline airline){
        this.name = airline.getName();
        this.address = airline.getAddress();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString(){
        return "AirlineCreateDTO{" + "name='" + '\'' + ", address='" + address + '}';
    }
}
