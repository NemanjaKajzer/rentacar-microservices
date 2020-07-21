import {LoginInfo} from './login-info';
import {UserType} from '../enums/UserType';

export class User {
  id: number;
  name: string;
  surname: string;
  jmbg: string;
  phoneNumber: string;
  loginInfo: LoginInfo;
  userType: UserType;


  constructor() {
    this.loginInfo = new LoginInfo();
  }
}
