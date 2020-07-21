export class CommentDto {
  message: string;
  grade: number;
  ad: number;
  userId: number;

  constructor(message: string, rating: number, ad: number, userId: number) {
    this.message = message;
    this.grade = rating;
    this.ad = ad;
    this.userId = userId;
  }
}
