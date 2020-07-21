import { AdvertisementInCart } from '../model/advertisementInCart';
import { RequestStates } from '../enums/requestStates';

export class BookingRequestDTO {
 
    id: number;

    userForId: number;

    userToId: number;

    advertisement:AdvertisementInCart;

    stateOfRequest: RequestStates;

    groupId: number;

    together: boolean;
   
    timeFrom: Date;

    timeTo: Date;

}
