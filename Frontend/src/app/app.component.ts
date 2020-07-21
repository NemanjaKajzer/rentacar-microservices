import { Component } from '@angular/core';
import {RegisterService} from './services/RegisterService/register.service';
import {EndUser} from './model/endUser';
import {LoginService} from './services/LoginService/login.service';
import {SessionService} from './services/SessionService/session.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angularclient';

  constructor(private registrationService: RegisterService, private loginService: LoginService, private sessionService: SessionService) {
    this.loginService.getUserByUsername(localStorage.getItem('korisnik')).subscribe(data => {
      this.sessionService.ulogovaniKorisnik = data;
      if (this.sessionService.ulogovaniKorisnik.userType.toString() === 'ENDUSER') {
        this.sessionService.isEndUser = true;
        this.sessionService.isAgent = false;
        this.sessionService.isAdmin = false;
      } else if (this.sessionService.ulogovaniKorisnik.userType.toString() === 'AGENT') {
        this.sessionService.isEndUser = false;
        this.sessionService.isAgent = true;
        this.sessionService.isAdmin = false;
      } else if (this.sessionService.ulogovaniKorisnik.userType.toString() === 'ADMINISTRATOR') {
        this.sessionService.isEndUser = false;
        this.sessionService.isAgent = false;
        this.sessionService.isAdmin = true;
      }

    });
  }

  register() {
    this.registrationService.register(new EndUser()).subscribe();
  }
}
