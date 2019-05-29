import {BrowserModule} from '@angular/platform-browser';
import {ErrorHandler, NgModule} from '@angular/core';
import {HashLocationStrategy, LocationStrategy} from "@angular/common";
import {HTTP_INTERCEPTORS} from "@angular/common/http";
import {HttpModule} from '@angular/http';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {SharedModule} from "./shared/shared.module";
import {AnonymusGuard} from "./core/guards/anonymus.guard";
import {CoreModule} from "./core/core.module";
import {ToasterModule} from "angular5-toaster/dist";
import {DatepickerModule} from "ngx-bootstrap";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";

import {AppErrorHandler} from "./core/error-handlers/app-error-handler";

import {JwtInterceptor} from "./core/interceptors/jwt-interceptor";

import {HttpClient, HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import {ReactiveFormsModule} from "@angular/forms";
import {FormsModule} from '@angular/forms';
import {AirlineService} from "./services/airline/airline.service";
//import {FlightService} from "./services/flight/flight.service";
//import {AdminService} from "./services/admin/admin.service";
//import {AddAirlineServiceService} from "./services/airline/add-airline-service.service"
//import {AccountService} from "./services/account/account.service";
//import {ReservationService} from "./services/reservation/reservation.service";
//import {SystemService} from "./services/system/system.service"

import {AuthService} from "./services/auth.service"
import {JwtService} from './services/jwt.service';
import {AppComponent} from './app.component';
import {HomePageComponent} from './components/home-page/home-page.component';
//import {AddAirlineComponent} from './components/add-arline/add-airline.component';
//import {AddFlightComponent} from './components/add-flight/add-flight.component';
//import {AddAirlineAdminComponent} from './components/add-airline-admin/add-airline-admin.component';
//import {LoginComponent} from './components/login/login.component';
import {NavbarComponent} from './components/navbar/navbar.component';
//import {RegistrationComponent} from './components/registration/registration.component';

import {BsDropdownModule} from 'ngx-bootstrap/dropdown';
import {TooltipModule} from 'ngx-bootstrap/tooltip';
import {ModalModule} from 'ngx-bootstrap/modal';

//import { ProfilComponent } from './components/profil/profil.component';
//import { ChangePasswordComponent } from './components/change-password/change-password.component';
//import { ShowAirlinesComponent } from './components/show-airlines/show-airlines.component';
import { TabsModule } from 'ngx-bootstrap';
//import { AirlineDetailsComponent } from './components/airline-details/airline-details.component';
//import { FriendsService } from "./services/friends/friends.service";
import {AgmCoreModule} from "@agm/core";
//import { AdminPanelComponent } from './components/admin-panel/admin-panel.component';
//import { ShowAirlineComponent } from './components/show-airline/show-airline.component';


@NgModule({
  exports: [RouterModule],
  declarations: [
    AppComponent,
    HomePageComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    HttpModule,
    ToasterModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyBtEDXxVtj8B6Pe_w5S0C7rx8p8rMgaVPU'
    }),
    SharedModule,
    DatepickerModule,
    NgbModule.forRoot(),
    TabsModule.forRoot(),
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot(),
    CoreModule,
    RouterModule.forRoot([
      {
        path: '',
        component: HomePageComponent
      },
      {
        path: 'home',
        component: HomePageComponent
      }
    ],)
  ],
  providers: [
    {
      provide: ErrorHandler,
      useClass: AppErrorHandler
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: JwtInterceptor,
      multi: true
    },
    {
      provide: LocationStrategy,
      useClass: HashLocationStrategy
    },
    HttpClientModule, JwtService],
  bootstrap: [AppComponent],
  entryComponents: []
})
export class AppModule { }
