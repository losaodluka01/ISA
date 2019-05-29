import { Component, OnInit } from '@angular/core';
import { JwtService } from "../../services/jwt.service";
import { AirlineCreate } from "../../models/airlineCreate"
import { AirlineService } from "../../services/airline/airline.service";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  airlines: Array<AirlineCreate>;

  constructor(protected jwtService: JwtService, private airlineService: AirlineService) {
    this.airlineService.getAllAirlines().subscribe(data =>{
      this.airlines = data as Array<AirlineCreate>;
      console.log(this.airlines);
    });
  }

  ngOnInit() {
  }

}
