import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {UserDTO} from '../../../dtos/user-dto';
import {RegisterService} from '../../../services/RegisterService/register.service';
import {SessionService} from '../../../services/SessionService/session.service';
import {AgentDTO} from '../../../dtos/agent-dto';

@Component({
  selector: 'app-agent-register',
  templateUrl: './agent-register.component.html',
  styleUrls: ['./agent-register.component.css']
})
export class AgentRegisterComponent implements OnInit {
  agent: AgentDTO = new AgentDTO();
  forma: FormGroup;
  constructor(private formBuilder: FormBuilder, private registerService: RegisterService, private sessionService: SessionService) { }

  ngOnInit() {
    this.forma = this.formBuilder.group({
      name: [''],
      surname: [''],
      username: [''],
      email: [''],
      jmbg: [''],
      phone: [''],
      bsregnum: [''],
      adress: ['']
    });
  }

  onSubmit() {
    console.log(this.agent);
    this.agent.password = '12345678';
    this.registerService.registerAgent(this.agent).subscribe(data => {
        this.sessionService.adminhome = true;
        this.sessionService.agentreg = false;
        alert('Uspešno registrovan agent!');
      },
        error => {
        if (error.error === 1) {
          alert('Username is taken!');
        } else if (error.error === 2) {
          alert('Email is taken!');
        } else if (error.error === 3) {
          alert('Jmbg already exists!');
        } else {
          alert('Internal server error');
        }
      });
  }
}
