import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule} from '@angular/core';
import {RouterModule} from "@angular/router";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms"
import { AppRoutingModule } from './app-routing.module';





import {AirlineCreate} from "./models/airlineCreate";

;



import { AppComponent } from './app.component';
import { HomePageComponent } from './components/home-page/home-page.component';

import {AirlineService} from "./services/airline/airline.service";
import {JwtService} from "./services/jwt.service";

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule.forRoot([
      {
        path:'',
        component: HomePageComponent
      },
      {
        path:'home',
        component:HomePageComponent
      }
    ],)
  ],
  providers: [ AirlineService, JwtService],
  bootstrap: [AppComponent]
})
export class AppModule { }
