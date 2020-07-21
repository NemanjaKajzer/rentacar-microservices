import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {EndUser} from '../../model/endUser';

const httpOptions = {headers: new HttpHeaders({'Content-Type' : 'application/json'})};


@Injectable({
  providedIn: 'root'
})
export class EndUserService {

  constructor(private http: HttpClient) { }

  public getUnregistered() {
    console.log('getuje neregistrovane');
    return this.http.get<EndUser[]>('server/authentication/getUnregistered', httpOptions);
  }

  public getAdminUnregistered(){
    return this.http.get<EndUser[]>('server/authentication/getAdminUnregistered', httpOptions);
  }

  public confirm(id: number){
    return this.http.post<string>('server/authentication/accept', id, httpOptions);
  }

  public reject(id: number) {
    return this.http.post<string>('server/authentication/reject', id, httpOptions);
  }

  public getRegisteredUsers() {
    return this.http.get<EndUser[]>('/server/authentication/getRegisteredUsers', httpOptions);
  }

  public deactivate(id: number) {
    return this.http.post(`/server/authentication/deactivate/${id}`, httpOptions);
  }

  public block(id: number) {
    return this.http.post(`/server/authentication/block/${id}`, httpOptions);
  }

  public unblock(id: number) {
    return this.http.post(`/server/authentication/unblock/${id}`, httpOptions);
  }

  public getRentedCars(id: number) {
    return this.http.get<number[]>('/server/authentication/getRentedCars/' + id, httpOptions);
  }
}
