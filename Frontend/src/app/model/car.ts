import {FuelType} from '../enums/fuelType';
import {TransmissionType} from '../enums/transmissionType';
import {CarClass} from '../enums/carClass';

export class Car {
  model: string;
  brand: string;
  fuelType: FuelType;
  transmissionType: TransmissionType;
  carClass: CarClass;
  price: number;
  travelled: number;
  carSeats: number;


  constructor(model: string, brand: string, fuelType: FuelType, transmissionType: TransmissionType, carClass: CarClass, price: number, travelled: number, carSeats: number) {
    this.model = model;
    this.brand = brand;
    this.fuelType = fuelType;
    this.transmissionType = transmissionType;
    this.carClass = carClass;
    this.price = price;
    this.travelled = travelled;
    this.carSeats = carSeats;
  }
}
