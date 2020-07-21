import {EndUser} from '../endUser';
import {RequestStates} from '../../enums/requestStates';
import { Advertisement } from '../advertisement';

export class BookingRequest {
 
    id: number;

    userForId: number;

    userToId: number;

    advertisement:number;

    stateOfRequest: RequestStates;

    groupId: number;

    together: boolean;
   
    timeFrom: Date;

    timeTo: Date;

}
