import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {CarDetails} from '../../model/car-details';

const httpOptions = {headers: new HttpHeaders({'Content-Type' : 'application/json'})};

@Injectable({
  providedIn: 'root'
})
export class CarDetailsService {

  constructor(private http: HttpClient) { }

  public getAllDetails() {
    return this.http.get<CarDetails[]>('/server/cardetails/getAllDetails', httpOptions);
  }

  public save(carDetail: CarDetails) {
    const body = JSON.stringify(carDetail);
    return this.http.post<number>('/server/cardetails/save', body, httpOptions);
  }

  public delete(code: string) {
    return this.http.post(`/server/cardetails/delete/${code}`, httpOptions);
  }
}
