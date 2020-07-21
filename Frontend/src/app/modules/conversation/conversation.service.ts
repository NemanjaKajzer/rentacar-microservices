import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Advertisement } from 'src/app/model/advertisement';
import { AdvertisementInCart } from 'src/app/model/advertisementInCart';
import { BookingRequest } from 'src/app/model/requests/bookingRequest';
import { User } from 'src/app/model/user';
import { MessageDTO } from 'src/app/model/messageDTO';

import { ConversationMessage } from 'src/app/model/conversationMessage';

const httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
  };


  
@Injectable()
  export class ConversationService {
    private requestUrl: string;
    constructor(private http: HttpClient) {}

    
      public getConversation(id:number) {
      this.requestUrl = '/server/inbox/getConversation';
      return this.http.post<Array<ConversationMessage>>(this.requestUrl,id, httpOptions);
      }

      

     

      public sendMessage(message: MessageDTO){
        
        const body = JSON.stringify(message);
        return this.http.post<MessageDTO>('/server/inbox/new', body, httpOptions);
        
      }

  }

