import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {SessionService} from '../../../services/SessionService/session.service';
import {CarReport} from '../../../model/car-report';
import {AgentService} from '../../../services/AgentService/agent.service';

@Component({
  selector: 'app-create-report',
  templateUrl: './create-report.component.html',
  styleUrls: ['./create-report.component.css']
})
export class CreateReportComponent implements OnInit {
  id: number;
  travelled: string;
  comment: string;

  constructor(private router: Router, private activatedRoute: ActivatedRoute, private sessionService: SessionService, private agentService: AgentService) { }

  ngOnInit() {
    this.activatedRoute.params.subscribe(params => {
      this.id = params.id;
    });
    console.log(this.id);
  }

  onSubmit() {
    const report = new CarReport(this.id, +this.travelled, this.comment);
    console.log(report);
    this.agentService.saveReport(report).subscribe(data => {
      this.sessionService.report = true;
      this.router.navigate(['/agent']);
    });
  }
}
