import {Component, OnInit} from '@angular/core';
import {AdvertisementService} from '../../../services/advertisement.service/advertisement.service';
import {ActivatedRoute, Router} from '@angular/router';
import {CommentDto} from '../../../dtos/comment-dto';
import {CommentService} from '../../../services/CommentService/comment.service';
import {SessionService} from '../../../services/SessionService/session.service';
import {AdvertisementDTO} from '../../../dtos/advertisement-dto';
import {CommentPreviewDTO} from '../../../dtos/comment-preview-dto';
import {ReplyDTO} from '../../../dtos/reply-dto';
import {EndUserService} from '../../../services/EndUserService/end-user.service';
import {UserType} from '../../../enums/UserType';

@Component({
  selector: 'app-advertisement-details',
  templateUrl: './advertisement-details.component.html',
  styleUrls: ['./../advertisement.component.css']
})
export class AdvertisementDetailsComponent implements OnInit {
  stars: number[] = [1, 2, 3, 4, 5];
  dataSource: AdvertisementDTO = new AdvertisementDTO();
  id: number;
  selectedValue: number;
  comment: string;
  rented: boolean;
  rentedCars: number[];
  replyDTO: ReplyDTO;
  replyText: string;

  constructor(private endUserService: EndUserService,  private messageService: CommentService, private advertisementService: AdvertisementService, private router: Router,
              private activatedRoute: ActivatedRoute, private sessionService: SessionService) {
    this.activatedRoute.params.subscribe(
      params => {
        this.id = params.id;
        console.log(this.id);
      });
    this.advertisementService.getAdvertisementPreview(this.id).subscribe(
      data => {
        this.dataSource = data;

        this.dataSource.comments.forEach(item => {
          if (item.replyDTO === undefined) {
            item.replyDTO = new ReplyDTO();
          }
        });

        console.log(this.dataSource);
        console.log('Komentari: ' + this.dataSource.comments);
        if (this.sessionService.ulogovaniKorisnik.userType.toString() === 'ENDUSER') {
          this.endUserService.getRentedCars(this.sessionService.ulogovaniKorisnik.id).subscribe(carIds => {
            this.rentedCars = carIds;
            console.log(this.rentedCars);

            this.rentedCars.forEach(item => {
              if (item.toString() === this.id.toString()) {
                this.rented = true;
                console.log('Rented: ' + this.rented);
              }
            });
          });
        }
      });
  }

  ngOnInit() {

  }

  countStar(star) {
    this.selectedValue = star;
    console.log('Value of star', star);
  }

  onSubmit() {
    const newComment = new CommentDto(this.comment, this.selectedValue, this.dataSource.id, this.sessionService.ulogovaniKorisnik.id);

    this.messageService.saveCommentAndGrade(newComment).subscribe(data => {
      const reply = new ReplyDTO();
      const listComment = new CommentPreviewDTO(this.comment,
        this.sessionService.ulogovaniKorisnik.loginInfo.email, this.selectedValue);
      listComment.replyDTO = reply;

      if(this.dataSource.comments === undefined){
        this.dataSource.comments = [] as CommentPreviewDTO[];
      }
    //  this.dataSource.comments.push(listComment);
    alert("Komentar poslat na procenu");

      this.comment = '';
      this.selectedValue = -1;
    });
  }

  sendReply(comment: CommentPreviewDTO){
    this.replyDTO = new ReplyDTO();

    this.replyDTO.agentMail = this.sessionService.ulogovaniKorisnik.loginInfo.email;
    this.replyDTO.comment = comment.replyText;
    this.replyDTO.id = comment.id;

    comment.replyDTO = this.replyDTO;

    this.advertisementService.saveReply(this.replyDTO).subscribe();
  }
}
