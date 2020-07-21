import {Advertisement} from '../model/advertisement';
import { AdvertisementInCart } from './advertisementInCart';

export class ItemInCartFront {
    
    id: number;
    advertisementCreationDTO: AdvertisementInCart;
    timeFrom: Date;
    timeTo: Date;
    owner: boolean;
    together:boolean;
    
    constructor() {
  
    }
  
  
  }
  