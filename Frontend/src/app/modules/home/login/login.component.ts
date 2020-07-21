import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {LoginService} from '../../../services/LoginService/login.service';
import {User} from '../../../model/user';
import {SessionService} from '../../../services/SessionService/session.service';
import {Router} from '@angular/router';
import {UserType} from '../../../enums/UserType';
import {AgentService} from '../../../services/AgentService/agent.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User;
  username: string;
  password: string;
  forma: FormGroup;
  constructor(private agentService: AgentService, private formBuilder: FormBuilder, private loginService: LoginService, private sessionService: SessionService,
              private router: Router) {
    this.user = new User();
  }

  ngOnInit() {

this.loginService.loginToken().subscribe();

  }

  onSubmit() {


    this.loginService.login(this.username, this.password).subscribe(
      data => {
        console.log(data);
        this.loginService.getUserByUsername(this.username).subscribe(user => {
          console.log(user);
          localStorage.setItem('korisnik', user.loginInfo.username);
          this.sessionService.ulogovaniKorisnik = user;
          console.log('proverava')
          if (user.userType.toString() === 'ADMINISTRATOR') {
            console.log('administrator je');
            this.sessionService.isAdmin = true;
            this.sessionService.isAgent = false;
            this.sessionService.isEndUser = false;
            console.log(this.sessionService.isAdmin + ' Admin registrovan');
            this.router.navigate(['/administrator']);
          } else if (user.userType.toString() === 'AGENT') {
            // this.agentService.checkPasswordChanged().subscribe(isChanged =>{
            //   if (isChanged === false) {
            //     this.sessionService.pwChanging = true;
            //     this.router.navigate(['/izmenaLozinke']);
            //   } else {
                this.sessionService.isAgent = true;
                this.sessionService.isAdmin = false;
                this.sessionService.isEndUser = false;
                this.router.navigate(['/agent']);
              // }
            // });

          } else if (user.userType.toString() === 'ENDUSER') {
            this.sessionService.isEndUser = true;
            this.sessionService.isAgent = false;
            this.sessionService.isAdmin = false;

          }
        });

      },
      error => alert('Neuspesno logovanje')
    );

  }

}
