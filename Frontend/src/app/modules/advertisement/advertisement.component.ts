
import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Advertisement} from 'src/app/model/advertisement';
import {AdvertisementService} from '../../services/advertisement.service/advertisement.service';
import {FuelType} from '../../enums/fuelType';
import {TransmissionType} from '../../enums/transmissionType';
import {CarClass} from '../../enums/carClass';
import {CarDetails} from '../../model/car-details';
import {CarDetailsService} from '../../services/CarDetailsService/car-details.service';
import {SessionService} from '../../services/SessionService/session.service';


@Component({
  selector: 'app-advertisement',
  templateUrl: './advertisement.component.html',
  styleUrls: ['./advertisement.component.css']
})
export class AdvertisementComponent implements OnInit {
  loading = false;
  forma: FormGroup;
  submitted = false;
  advertisement: Advertisement;
  fuelType: string;
  transType: string;
  carClass: string;
  brand: string;
  model: string;
  carDetails: CarDetails[];
  slike: String[];

  carClasses: CarDetails[];
  carFuels: CarDetails[];
  carModels: CarDetails[];
  carBrands: CarDetails[];
  carGearshifts: CarDetails[];
  selectedFiles: File[];

  constructor(private formBuilder: FormBuilder, private advertisementService: AdvertisementService,
              private carDetailsService: CarDetailsService) {
    this.advertisement = new Advertisement();
    this.advertisementService.getAllDetails().subscribe(data => {
      this.carDetails = data;
      this.carClasses = this.carDetails.filter(item => {
        return item.type.toLowerCase() === 'carclass';
      });

      this.carFuels = this.carDetails.filter(item => {
        return item.type.toLowerCase() === 'fueltype';
      });

      this.carModels = this.carDetails.filter(item => {
        return item.type.toLowerCase() === 'carmodel';
      });

      this.carBrands = this.carDetails.filter(item => {
        return item.type.toLowerCase() === 'brand';
      });

      this.carGearshifts = this.carDetails.filter(item => {
        return item.type.toLowerCase() === 'gearshift';
      });
    });
  }

  ngOnInit(): void {
    this.forma = this.formBuilder.group({
      name: [''],
      model: [''],
      brand: [''],
      fuelType: [''],
      transType: [''],
      carClass: [''],

      travelled: [''],
      price: [''],
      discount:[''],
      carSeats: ['']
    });
  }

  onSubmit() {
    this.advertisement.fuelType = this.fuelType;
    this.advertisement.carClass = this.carClass;
    this.advertisement.transType = this.transType;
    this.advertisement.brand = this.brand;
    this.advertisement.model = this.model;

     this.advertisement.pictures = this.slike;
    // tslint:disable-next-line:prefer-for-of
     if(this.selectedFiles.length !== undefined) {
       for (let i = 0; i < this.selectedFiles.length; i++) {
         this.advertisementService.upload(this.selectedFiles[i]).subscribe();
       }
     }

    console.log(this.advertisement);
    this.advertisementService.save(this.advertisement).subscribe();
  }

  


  onFileSelected(event) {
    console.log(event);
    this.selectedFiles = event.target.files;

    this.slike= new Array<String>();

    for(let i=0; i<this.selectedFiles.length;i++){
      console.log("Ovo su slike "+this.selectedFiles[i].name);
     this.slike.push("assets/images/"+this.selectedFiles[i].name);

    }


  }

}
