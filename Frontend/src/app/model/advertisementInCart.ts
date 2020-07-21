import {FuelType} from '../enums/fuelType';
import {TransmissionType} from '../enums/transmissionType';
import {CarClass} from '../enums/carClass';
import { User } from './user';

export class AdvertisementInCart {
  id: number;
  name: string;
  model: string;
  brand: string;
  fuelType: string;
  transType: string;
  carClass: string;
  travelled: number;
  price: number;
  carSeats: number;
  postedByID: number;
  owner: boolean;
  together:boolean;
  

  constructor() {

  }


}
