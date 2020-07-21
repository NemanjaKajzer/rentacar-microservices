import { Component, OnInit } from '@angular/core';
import {AdvertisementService} from '../../services/advertisement.service/advertisement.service';
import {Advertisement} from '../../model/advertisement';
import {FormBuilder, FormGroup} from '@angular/forms';
import { ReserveDTO } from 'src/app/dtos/reserveDTO';

@Component({
  selector: 'app-reserve',
  templateUrl: './reserve.component.html',
  styleUrls: ['./reserve.component.css']
})
export class ReserveComponent implements OnInit {

  advertisements: Advertisement[];
  advId:number;
  timeFrom: Date;
  timeTo: Date;
  reserveForm: FormGroup;
  adName: string;
  adId: number;

  reserve: ReserveDTO;

  constructor(private advertisementService: AdvertisementService, private formBuilder: FormBuilder) {
  
   }

  ngOnInit() {

    this.advertisementService.getAllByUser().subscribe(
      data => {
        console.log(data);
        this.advertisements = data;
      });

    this.reserveForm = this.formBuilder.group({
      advId: [''],
      timeFrom: [''],
      timeTo: ['']
    });

  }

  onSubmit() {
   
    this.reserve=new ReserveDTO();
    
    this.reserve.advertisementId=this.adId;
    this.reserve.timeFrom = this.timeFrom;
    this.reserve.timeTo = this.timeTo;

    console.log(this.reserve);


   this.advertisementService.updateTime(this.reserve).subscribe();
  }

}