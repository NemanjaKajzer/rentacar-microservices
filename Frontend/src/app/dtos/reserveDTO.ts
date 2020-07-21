import {User} from '../model/user';
import {CommentDto} from './comment-dto';
import {CommentPreviewDTO} from './comment-preview-dto';
import {ReplyDTO} from './reply-dto';

export class ReserveDTO {
  advertisementId: number;
  timeFrom: Date;
  timeTo: Date;
}
