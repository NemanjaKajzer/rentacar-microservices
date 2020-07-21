import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AdvertisementService} from '../../services/advertisement.service/advertisement.service';

@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {
  id: any;
  private idMaxTravelled: any;
  private idMaxComments: any;
  private idBestGrade: any;
  private maxTravelled: number;
  private bestGrade: number ;
  private maxComments: number;

  constructor(private router: Router, private activatedRoute: ActivatedRoute,
              private advertisementService: AdvertisementService) { }

  ngOnInit() {
    this.idMaxTravelled = 1;
    this.idMaxComments = 1;
    this.idBestGrade = 1;
    this.maxTravelled = 0;
    this.maxComments = 0;
    this.bestGrade = 0;
    this.advertisementService.getAll().subscribe(
      data1 => {
        console.log(data1)
        // tslint:disable-next-line:prefer-for-of
        for (let i = 0; i < data1.length; i++) {
          if (data1[i].travelled >= this.maxTravelled)  {
            this.maxTravelled = data1[i].travelled;
            this.idMaxTravelled = data1[i].id;
          }
          if (data1[i].grade >= this.bestGrade) {
            this.bestGrade = data1[i].grade;
            this.idBestGrade = data1[i].id;
          }
          this.advertisementService.getAllComments(data1[i].id).subscribe(
            data => {
              if (data.length === 0) {
                this.idMaxComments = 1;
              } else if (data.length >= this.maxComments) {
                this.maxComments = data.length;
                this.idMaxComments = data1[i].id;
              }
            }
          );
        }
        console.log('maxTravelled id ' + this.idMaxTravelled);
        console.log('maxComments id ' + this.idMaxComments);
        console.log('best grade id ' + this.idBestGrade);
        console.log('maxTravelled' + this.maxTravelled);
        console.log('maxComments' + this.maxComments);
        console.log('bestGrade' + this.bestGrade);
      });

  }

  openMostTravelled() {
    this.router.navigate(['/advertisement-details', this.idMaxTravelled]);
  }

  openMostComments() {
    this.router.navigate(['/advertisement-details', this.idMaxComments]);
  }

  openBestReview() {
    this.router.navigate(['/advertisement-details', this.idBestGrade]);
  }
}
