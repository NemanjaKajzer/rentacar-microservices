import { Component, OnInit } from '@angular/core';
import {Agent} from '../../../model/agent';
import {FormBuilder, FormGroup} from '@angular/forms';
import {SessionService} from '../../../services/SessionService/session.service';
import {LoginService} from '../../../services/LoginService/login.service';
import {UserDTO} from '../../../dtos/user-dto';
import {Router} from '@angular/router';

@Component({
  selector: 'app-izmena-lozinke',
  templateUrl: './izmena-lozinke.component.html',
  styleUrls: ['./izmena-lozinke.component.css']
})
export class IzmenaLozinkeComponent implements OnInit {
  agent: Agent = new Agent();
  pw: string;
  reppw: string;
  forma: FormGroup;
  constructor(private router: Router, private loginService: LoginService, private sessionService: SessionService, private formBuilder: FormBuilder) {
    console.log(this.sessionService.pwChanging);

  }

  ngOnInit() {
    this.forma = this.formBuilder.group({
      pw: ['']
    });
  }

  onSubmit() {
    if (this.pw !== this.reppw) {
      alert('Passwords do not match!');
      return;
    }
    const newPw = new UserDTO();
    newPw.password = this.pw;
    console.log(this.sessionService.login);
    newPw.jmbg = this.sessionService.ulogovaniKorisnik.jmbg;
    this.loginService.passwordChanged(newPw).subscribe(data => {
      this.sessionService.pwChanging = false;
      this.sessionService.isAgent = true;
      this.sessionService.isAdmin = false;
      this.sessionService.isEndUser = false;
      alert('Password successfully changed!');
      this.router.navigate(['/agent']);
    });
  }

}
