import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {RegisterService} from '../../../services/RegisterService/register.service';

@Component({
  selector: 'app-register-confirm',
  templateUrl: './register-confirm.component.html',
  styleUrls: ['./register-confirm.component.css']
})
export class RegisterConfirmComponent implements OnInit {

  constructor(private router: Router, private registerService: RegisterService) { }

  ngOnInit() {
    const url = this.router.url;
    const splitted = url.split('=');
    this.registerService.verify(splitted[1]).subscribe(data => {
      console.log('treba da ode na drugu stranicu')
      this.router.navigate(['/homepage']);
    });
  }

}
