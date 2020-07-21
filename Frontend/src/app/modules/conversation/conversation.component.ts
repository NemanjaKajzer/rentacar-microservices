import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MessageDTO } from 'src/app/model/messageDTO';
import { ConversationMessage } from 'src/app/model/conversationMessage';
import {FormBuilder, FormGroup} from '@angular/forms';
import { ConversationService } from './conversation.service';

@Component({
  selector: 'app-conversation',
  templateUrl: './conversation.component.html',
  styleUrls: ['./conversation.component.css']
})
export class ConversationComponent implements OnInit {
  idString:string;
  id:number;
  messages:ConversationMessage[];
  messageToSend:MessageDTO;
  forma:FormGroup;


  constructor(private route: ActivatedRoute,private conversationService:ConversationService, private formBuilder:FormBuilder) {
   this.messageToSend= new MessageDTO();
   }

  ngOnInit() {
    this.idString = this.route.snapshot.paramMap.get('id');
    this.id=Number(this.idString);
    
    this.conversationService.getConversation(this.id).subscribe(
      
      data=>{
        this.messages=data;

        this.messages.forEach(message => {
          
          message.replacedDate=message.timeSent.toString().replace("T"," ");

        });
        console.log(data);
      }

    )

    this.forma = this.formBuilder.group({
      
      text: ['']
     
    });


    console.log(this.id);
  }

sendMessage(){
  console.log(this.messageToSend.text);
  console.log(this.messageToSend);
  this.messageToSend.receiverID=this.id;
  console.log(this.messageToSend.receiverID);
  this.conversationService.sendMessage(this.messageToSend).subscribe();
}

}
