import { Injectable } from '@angular/core';
import {AirlineCreate} from "../../models/airlineCreate";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class AddAirlineServiceService {

  constructor(private http: HttpClient) {
  }

  sendRegistration(airline: AirlineCreate)
  {
    this.http.post("http://localhost:8080/api/admin/create_airline", airline).subscribe(data =>{
      console.log(data);
    });
  }

}
