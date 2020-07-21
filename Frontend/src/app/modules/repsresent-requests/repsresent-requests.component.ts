import { Component, OnInit } from '@angular/core';
import { RepresentRequestsService } from './represent-requests.service';
import { BookingRequest } from 'src/app/model/requests/bookingRequest';
import { RequestStates } from 'src/app/enums/requestStates';
import { BookingRequestDTO } from 'src/app/dtos/bookingRequestDTO';

@Component({
  selector: 'app-repsresent-requests',
  templateUrl: './repsresent-requests.component.html',
  styleUrls: ['./repsresent-requests.component.css']
})
export class RepresentRequestsComponent implements OnInit {
  groups: number[];
  requests: BookingRequestDTO[];
  napravioJedan: number;
  requestStatus: RequestStates;
  checker: number;


  constructor(private representRequestsService:RepresentRequestsService) {
    this.requestStatus=RequestStates.PENDING;
   }
  
  ngOnInit() {
    
    console.log(this.requestStatus);
    this.representRequestsService.getSpecificGroupsForCart( this.requestStatus).subscribe(
      
      data=>{
        this.groups=data;
      }

    )

    this.representRequestsService.getAllSpecificRequests( this.requestStatus).subscribe(
      data => {
        this.requests = data;
       
        
      }
      
    );
    this.checker=0;
  }

  
  public onChange(event): void {

    if(event.target.value==="PENDING"){
      this.requestStatus=RequestStates.PENDING;
      this.representRequestsService.getSpecificGroupsForCart(this.requestStatus).subscribe(
       
        data=>{
          this.groups=data;

          this.representRequestsService.getAllSpecificRequests(this.requestStatus).subscribe(

            data=>{
              this.requests=data;
    
            
            }
  
          )
          this.checker=0;
        },
        
      
      )
    }
    else if(event.target.value==="RESERVED"){
      this.requestStatus=RequestStates.RESERVED;
      this.representRequestsService.getSpecificGroupsForCart(this.requestStatus).subscribe(
       
        data=>{
          this.groups=data;

          this.representRequestsService.getAllSpecificRequests(this.requestStatus).subscribe(

            data=>{
              this.requests=data;
    
            
            }
  
          )
          this.checker=1;
        },
        
      
      )
      this.representRequestsService.getAllSpecificRequests(this.requestStatus).subscribe(

        data=>{
          this.requests=data;

        
        }

      )
    }
    else if(event.target.value==="CANCELED"){
      this.requestStatus=RequestStates.CANCELED;
      this.representRequestsService.getSpecificGroupsForCart(this.requestStatus).subscribe(
       
        data=>{
          this.groups=data;

          this.representRequestsService.getAllSpecificRequests(this.requestStatus).subscribe(

            data=>{
              this.requests=data;
    
            
            }
  
          )
          this.checker=1;
        },
      
      )
    }
    else if(event.target.value==="PAID"){
      this.requestStatus=RequestStates.PAID;
      this.representRequestsService.getSpecificGroupsForCart(this.requestStatus).subscribe(
       
        data=>{
          this.groups=data;

          this.representRequestsService.getAllSpecificRequests(this.requestStatus).subscribe(

            data=>{
              this.requests=data;
    
            
            }
  
          )
          this.checker=1;
        },
      
      )
    }

}

  acceptRequest(group: number){

    this.representRequestsService.acceptRequest(group).subscribe();
    this.representRequestsService.getSpecificGroupsForCart(this.requestStatus).subscribe(
       
      data=>{
        this.groups=data;
  
        this.representRequestsService.getAllSpecificRequests(this.requestStatus).subscribe(
  
          data=>{
            this.requests=data;
  
          
          }
  
        )
        this.checker=0;
      },
      
    
    )

  }

  
public cancelRequest(group: number){

  this.representRequestsService.cancelRequest(group).subscribe();
  this.representRequestsService.getSpecificGroupsForCart(this.requestStatus).subscribe(
       
    data=>{
      this.groups=data;

      this.representRequestsService.getAllSpecificRequests(this.requestStatus).subscribe(

        data=>{
          this.requests=data;

        
        }

      )
      this.checker=0;
    },
    
  
  )

}

  
}
