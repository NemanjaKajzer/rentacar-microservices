import {Advertisement} from '../model/advertisement';

export class ItemInCart {
    
    id: number;
    advertisementId: number;
    advertisementPostedById: number;
    timeFrom: Date;
    timeTo: Date;
    owner: boolean;
    together:boolean;
    
    constructor() {
  
    }
  
  
  }
  