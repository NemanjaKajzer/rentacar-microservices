import {LoginInfo} from './login-info';
import {User} from './user';

export class Agent extends User{
  number_ads: number;
  first_login: boolean;
  adress: string;
  bsregnum: string;

  constructor() {
    super();
  }
}
