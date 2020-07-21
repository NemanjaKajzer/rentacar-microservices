import { User } from './user';
import { UserMessageDTO } from '../dtos/userMessageDTO';


export class ConversationMessage {

  id: number;
  sender:UserMessageDTO;
  receiver:UserMessageDTO;
  text:string;
  timeSent: Date;
  replacedDate: string;
  
  
  


  constructor(){
  }

}
