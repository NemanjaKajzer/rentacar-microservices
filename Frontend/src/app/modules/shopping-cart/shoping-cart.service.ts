import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Advertisement } from 'src/app/model/advertisement';
import { AdvertisementInCart } from 'src/app/model/advertisementInCart';

import { ItemInCart } from 'src/app/model/itemInCart';
import { ItemInCartFront } from 'src/app/model/itemInCartFront';

const httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
  };


  
@Injectable()
  export class ShopingCartService {
    private requestUrl: string;
    constructor(private http: HttpClient) {}

    
      

      public getAllForCart() {
        this.requestUrl = '/server/booking/forCart';
        return this.http.get<Array<ItemInCartFront>>(this.requestUrl, httpOptions);
        }
  

      
    
      public sentRequests(itemsInCart :ItemInCart[]){
        const body = JSON.stringify(itemsInCart);
        return this.http.post<ItemInCartFront[]>('/server/booking/save', body, httpOptions);
        
      }

      public removeFromCart(itemInCart : ItemInCart){

        const body=JSON.stringify(itemInCart);
        return this.http.post<ItemInCartFront[]>('/server/booking/remove',body,httpOptions);

      }

  }

