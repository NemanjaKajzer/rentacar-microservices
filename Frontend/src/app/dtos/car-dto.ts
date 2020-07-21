import {FuelType} from '../enums/fuelType';
import {TransmissionType} from '../enums/transmissionType';
import {CarClass} from '../enums/carClass';

export class CarDTO {
  public id: number;
  public name: string;
  public model: string;
  public brand: string;
  public fuelType: FuelType;
  public transmissionType: TransmissionType;
  public carClass: CarClass;
  public travelled: number;
  public carSeats: number;

  constructor() {
  }
}
