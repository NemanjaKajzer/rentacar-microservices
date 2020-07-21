import { FuelType } from '../enums/fuelType';
import { TransmissionType } from '../enums/transmissionType';
import { CarClass } from '../enums/carClass';

export class FilterAdsDTO {
  brand: string;
  model: string;
  fuelType: string;
  transmissionType: string;
  carClass: string;
  travelledFrom: number;
  travelledTo: number;
  priceFrom: number;
  priceTo: number;
  carSeats: number;
  timeFrom: Date;
  timeTo: Date;



  constructor() {

  }


}
