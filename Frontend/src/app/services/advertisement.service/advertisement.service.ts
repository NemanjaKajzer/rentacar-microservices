import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Advertisement } from 'src/app/model/advertisement';
import { FilterAdsDTO } from 'src/app/model/filterAdsDTO';
import { ItemInCart } from 'src/app/model/itemInCart';
import {AdvertisementDTO} from '../../dtos/advertisement-dto';
import {ReplyDTO} from '../../dtos/reply-dto';
import {CommentPreviewDTO} from '../../dtos/comment-preview-dto';
import {CarDetails} from '../../model/car-details';
import { AdvertisementInCart } from 'src/app/model/advertisementInCart';
import { ReserveDTO } from 'src/app/dtos/reserveDTO';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type' : 'application/json'})
};

@Injectable()
export class AdvertisementService {
  private requestUrl: string;
  constructor(private http: HttpClient) {}

  public getAllDetails() {
    return this.http.get<CarDetails[]>('/server/advertisement/getAllDetails', httpOptions);
  }

  public saveCarDetail(cardetail: CarDetails){
    const body = JSON.stringify(cardetail);
    return this.http.post<CarDetails>('/server/advertisement/saveCarDetail', body, httpOptions);
  }

  public deleteCarDetail(cardetail: CarDetails){
    const body = JSON.stringify(cardetail);
    return this.http.post<CarDetails>('/server/advertisement/deleteCarDetail', body, httpOptions);
  }

  public upload(file: File) {
    const fd = new FormData();
    fd.append('file', file, file.name);
    return this.http.post('/server/advertisement/saveImage', fd);
  }

  public save(advertisement: Advertisement) {
    console.log(advertisement);
    return this.http.post<Advertisement>('/server/advertisement/save', advertisement, httpOptions);
  }

  public getAll() {
    this.requestUrl = '/server/advertisement/all';
    return this.http.get<Array<Advertisement>>(this.requestUrl, httpOptions);
  }

  public getAllByIds(advertisementsIds: number[]){

    this.requestUrl='/server/advertisement/allByIds';
     const body = JSON.stringify(advertisementsIds);
    return this.http.post<Array<AdvertisementInCart>>(this.requestUrl,body, httpOptions);

  }

  public getAllByUser(){

    this.requestUrl = '/server/advertisement/getAllByUser';
    return this.http.get<Array<Advertisement>>(this.requestUrl, httpOptions);


  }

  public updateTime(reserve : ReserveDTO){

    this.requestUrl='/server/booking/reserve';
    const body = JSON.stringify(reserve);

   return this.http.post<Array<AdvertisementInCart>>(this.requestUrl,body, httpOptions);


  }

  public addAd(itemInCart: ItemInCart) {
    const body = JSON.stringify(itemInCart);
    return this.http.post<ItemInCart>('/server/booking/addItem', body, httpOptions);
  }

  public filter(filterAdsDTO: FilterAdsDTO) {
    console.log(filterAdsDTO);
    const body = JSON.stringify(filterAdsDTO);
    return this.http.post<Array<Advertisement>>('/server/advertisement/filterAdv', body, httpOptions);
  }

  public getAdvertisement(id: number) {
    this.requestUrl = '/server/advertisement/' + id;
    return this.http.get<Advertisement>(this.requestUrl, httpOptions);
  }

  public update(advertisement: Advertisement) {
    this.requestUrl = '/server/advertisement/update';
    const body = JSON.stringify(advertisement);
    return this.http.post<Advertisement>(this.requestUrl, body, httpOptions);
  }

  public getAdvertisementPreview(id: number) {
    this.requestUrl = `/server/advertisement/preview/${id}` ;
    return this.http.get<AdvertisementDTO>(this.requestUrl, httpOptions);
  }

  public getAllByPostedBy(id: number) {
      return this.http.get<Advertisement[]>('server/advertisement/getAllByPostedBy/' + id, httpOptions);
  }

  public saveReply(replyDTO: ReplyDTO) {
      const body = JSON.stringify(replyDTO);
      console.log(replyDTO);
      return this.http.post<void>('/server/advertisement/saveReply', body, httpOptions);
  }

  public getAllComments(id: number) {
      this.requestUrl = '/server/advertisement/getAllComments/' + id;
      return this.http.get<Array<CommentPreviewDTO>>(this.requestUrl, httpOptions);
  }
}

