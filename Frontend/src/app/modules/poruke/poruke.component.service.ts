import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Advertisement } from 'src/app/model/advertisement';
import { AdvertisementInCart } from 'src/app/model/advertisementInCart';
import { BookingRequest } from 'src/app/model/requests/bookingRequest';
import { User } from 'src/app/model/user';
import { MessageDTO } from 'src/app/model/messageDTO';
import { UserMessageDTO } from 'src/app/dtos/userMessageDTO';

const httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
  };


  
@Injectable()
  export class PorukeService {
    private requestUrl: string;
    constructor(private http: HttpClient) {}

    //TRENUTNO DOBAVLJA SVE USERE a ne one s kojima sme da se dop
    //
      public getAllUsers() {
      this.requestUrl = '/server/inbox/allUsers';
      return this.http.get<Array<UserMessageDTO>>(this.requestUrl, httpOptions);
      }

      
//TRENUTNO DOBAVLJA SVE USERE
//allMessagableUsers ovo treba da ide umest allUsers
      public getAllUsersForDropdown() {
        this.requestUrl = '/server/inbox/allMessagableUsers';
        return this.http.get<Array<User>>(this.requestUrl, httpOptions);
        }

      public sendMessage(message: MessageDTO){
        
        const body = JSON.stringify(message);
        return this.http.post<MessageDTO>('/server/inbox/new', body, httpOptions);
        
      }

  }

