import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Advertisement } from 'src/app/model/advertisement';
import { AdvertisementInCart } from 'src/app/model/advertisementInCart';
import { BookingRequest } from 'src/app/model/requests/bookingRequest';
import { RequestStates } from 'src/app/enums/requestStates';
import { BookingRequestDTO } from 'src/app/dtos/bookingRequestDTO';

const httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
  };


  
@Injectable()
  export class HistoryService {
    private requestUrl: string;
    constructor(private http: HttpClient) {}

    
     


      public   getAllSpecificRequests(state: RequestStates) {
        this.requestUrl = '/server/booking/getAllSpecificForBuyer';
        return this.http.post<Array<BookingRequestDTO>>(this.requestUrl, state ,httpOptions);
        }
    
          
    
      public getSpecificGroupsForCart(state: RequestStates) {
      this.requestUrl = '/server/booking/grups';
      return this.http.post<Array<number>>(this.requestUrl, state, httpOptions);
          }

     

      public cancelRequest(group : number ){

        return this.http.post<number>('server/booking/cancelRequest', group,httpOptions );
      }

  }

