import {Component, OnInit} from '@angular/core';
import {CarDetails} from '../../../model/car-details';
import {Data} from '../../../enums/data.enum';
import {CarDetailsService} from '../../../services/CarDetailsService/car-details.service';
import {AdvertisementService} from '../../../services/advertisement.service/advertisement.service';

@Component({
  selector: 'app-sifrarnik',
  templateUrl: './sifrarnik.component.html',
  styleUrls: ['./sifrarnik.component.css']
})
export class SifrarnikComponent implements OnInit {
  datasource: CarDetails[];
  helper: CarDetails[];
  typeOfData: string;
  newCarDetail: CarDetails = new CarDetails();
  constructor(private advertisementService: AdvertisementService) {
    this.advertisementService.getAllDetails().subscribe(data => {
      this.datasource = data;
      this.helper = data;
      console.log(this.datasource);
    });

  }

  ngOnInit() {

  }

  filter(value: string) {
    console.log(value);
    if (value.toLowerCase() === 'all') {
      console.log('all');
      this.datasource = this.helper;
      return;
    }

    this.datasource = this.helper.filter(item => {
      let newValue;
      if (value.toLowerCase() !== 'fuel' && value.toLowerCase() !== 'gearshift' && value.toLowerCase() !== 'brand') {
        newValue = value.split(' ')[0] + value.split(' ')[1];
      } else {
        newValue = value.toLowerCase();
      }
      console.log(newValue.toLowerCase() + ' ' + item.type.toLowerCase());
      return newValue.toLowerCase() === item.type.toLowerCase();
    });
  }

  delete(object: CarDetails){
    console.log(object);
    this.advertisementService.deleteCarDetail(object).subscribe(data => {
      this.datasource.splice(this.datasource.indexOf(object));
      this.advertisementService.getAllDetails().subscribe(newData =>
        this.helper = newData);
    });
  }

  onSubmit() {
    if (this.newCarDetail.type === 'Car Model'){
      this.newCarDetail.type = 'CarModel';
    } else if(this.newCarDetail.type === 'Car Class'){
      this.newCarDetail.type = 'CarClass';
    }
    this.advertisementService.saveCarDetail(this.newCarDetail).subscribe(data => {
      this.datasource.push(this.newCarDetail);
      this.newCarDetail = new CarDetails();
    },
      error => {
        console.log(error);
        if (error.error === 2) {
          alert('The specified code already exists');
        } else if (error.error === 1) {
          alert('The specified name already exists');
        }
      });
  }

}
