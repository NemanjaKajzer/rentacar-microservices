import {User} from './user';
import {Advertisement} from './advertisement';

export class EndUser extends User {
  activity: boolean;
  advertisements: Array<Advertisement>;
  adminApproved: boolean;
  blocked: boolean;
  numberOfRequestsCanceled: number;
  rentedCars: Advertisement[];

  constructor() {
    super();
  }
}
