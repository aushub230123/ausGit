import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Review } from '../models/review';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {
  baseUrl : string = "http://localhost:8080/api/v1/reviews";
  constructor(private httpClient:HttpClient) {}

  getReviews(){
    console.log("productsURL" , this.baseUrl);
    return this.httpClient.get<Review[]>(this.baseUrl);
    
   }
   getReviewById(id: number) {
    //get
    const url :string = this.baseUrl + "/" + id;
    console.log(url);
    return this.httpClient.get<Review>(url);
  }
  createReview(review: Review) {
    //post : new emp
    return this.httpClient.post(this.baseUrl, review);
  }
  updateReview(reviewId:number, review:any) : Observable<Object> {
    //put : update emp
    return this.httpClient.put(`${this.baseUrl}/${reviewId}`, review);
  }
  deleteReview(id: number) {
    //post
    return this.httpClient.delete<Review>(this.baseUrl + "/" + id);
  }
}
