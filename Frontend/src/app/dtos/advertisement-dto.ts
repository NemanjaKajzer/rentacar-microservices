import {User} from '../model/user';
import {CommentDto} from './comment-dto';
import {CommentPreviewDTO} from './comment-preview-dto';
import {ReplyDTO} from './reply-dto';

export class AdvertisementDTO {
  id: number;
  name: string;
  model: string;
  brand: string;
  fuelType: string;
  transType: string;
  carClass: string;
  travelled: number;
  price: number;
  carSeats: number;
  postedBy: User;
  grade: number;
  comments: CommentPreviewDTO[];
}
