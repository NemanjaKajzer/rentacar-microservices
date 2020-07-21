import {ReplyDTO} from './reply-dto';

export class CommentPreviewDTO {
  id: number;
  constructor(comment: string, userMail: string, grade: number) {
    this.comment = comment;
    this.userMail = userMail;
    this.grade = grade;
    this.replyText = '';
  }
  comment: string;
  userMail: string;
  grade: number;
  replyDTO: ReplyDTO;
  replyText: string;
}
