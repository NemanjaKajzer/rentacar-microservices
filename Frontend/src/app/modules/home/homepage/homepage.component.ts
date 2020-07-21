import { Component, OnInit } from '@angular/core';
import {SessionService} from '../../../services/SessionService/session.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor(private sessionService: SessionService) { }

  ngOnInit() {

  }
}
