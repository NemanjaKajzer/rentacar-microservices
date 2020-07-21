import { Injectable } from '@angular/core';
import {User} from '../../model/user';
import {Advertisement} from '../../model/advertisement';

@Injectable({
  providedIn: 'root'
})
export class SessionService {
  /////////////////////////////// Registracija i login
  login: boolean;
  register: boolean;
  ulogovaniKorisnik: User;
  /////////////////////////////// Registracija i login
  /////////////////////////////// Uloge
  isAdmin = false;
  isAgent = false;
  isEndUser = false;
  /////////////////////////////// Uloge
  /////////////////////////////// Admin komponente
  adminhome = true;
  requests = false;
  agentreg = false;
  manageUsers = false;
  codebook = false;
  commentManagment = false;
  /////////////////////////////// Admin komponente
  /////////////////////////////// Random
  pwChanging = false;
  /////////////////////////////// Agent komponente
  homeAgent = true;
  report = false;
  enterReport = false;
  //////////////////////////////// Nesto
  rentedCars: Advertisement[];
  constructor() { }
}
