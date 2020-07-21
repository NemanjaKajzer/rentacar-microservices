import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {EndUser} from '../../model/endUser';
import {UserType} from '../../enums/UserType';
import {Observable} from 'rxjs';
import {UserDTO} from '../../dtos/user-dto';
import {AgentDTO} from '../../dtos/agent-dto';
import { User } from 'src/app/model/user';

const httpOptions = {headers: new HttpHeaders({'Content-Type' : 'application/json'})};


@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient) { }

  public register(endUser: User) {
    endUser.userType = UserType.ENDUSER;
    const body = JSON.stringify(endUser);
    return this.http.post<string>('/server/authentication/register', body, httpOptions);
  }

  public registerAgent(agentDTO: AgentDTO){
    const body = JSON.stringify(agentDTO);
    return this.http.post<number>('server/agent/register', body, httpOptions);
  }

  public verify(token: string) {
    return this.http.post<number>('/server/authentication/registrationConfirm', token, httpOptions);
  }
}
