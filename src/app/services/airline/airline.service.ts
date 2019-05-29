import { Injectable } from '@angular/core';
import {AirlineCreate} from "../../models/airlineCreate";
import {HttpClient} from "@angular/common/http";
import {Airline} from "../../models/airline";
import {Observable} from "rxjs/Observable";

@Injectable()
export class AirlineService {

  constructor(private http: HttpClient) {
  }

  sendRegistration(airline : AirlineCreate)
  {
    return this.http.post("http://localhost:8080/api/admin/create_airline", airline);
  }

  getAllAirlines()
  {
    return this.http.get("http://localhost:8080/api/airline/get_all");
  }

  deleteAirline(airline){
    return this.http.post("http://localhost:8080/api/airline/delete_airline", airline);
  }

  getAirlineById(id)
  {
    return this.http.get("http://localhost:8080/api/airline/get?id=" + id);
  }

  updateAirline(airline: Airline) {
    return this.http.post("http://localhost:8080/api/airline/update_airline", airline);
  }

  getLocation(city: string, address: string) : Observable<any> {
    return this.http.get(`api/location?address=${city} ${address}`);
  }

  getAirlineByAccount(){
    return this.http.get("http://localhost:8080/api/airline/get_airline");

  }
}
