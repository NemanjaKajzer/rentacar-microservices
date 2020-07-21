import { Component, OnInit } from '@angular/core';
import {AgentService} from '../../../services/AgentService/agent.service';
import {SessionService} from '../../../services/SessionService/session.service';
import {CarDTO} from '../../../dtos/car-dto';
import {Router} from '@angular/router';

@Component({
  selector: 'app-agents-cars',
  templateUrl: './agents-cars.component.html',
  styleUrls: ['./agents-cars.component.css']
})
export class AgentsCarsComponent implements OnInit {
  cars: CarDTO[];
  constructor(private agentService: AgentService, private sessionService: SessionService, private router: Router) { }

  ngOnInit() {
    this.agentService.getOwnersCars().subscribe(data => {
      this.cars = data;
      console.log(this.cars);
    });
  }

  enterReport(car: CarDTO) {
    this.router.navigate(['/report', car.id]);
  }
}
