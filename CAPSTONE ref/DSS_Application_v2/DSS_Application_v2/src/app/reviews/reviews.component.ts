import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Movie } from '../models/movie';
import { Review } from '../models/review';
import { MovieService } from '../service/movie.service';
import { ReviewService } from '../service/review.service';

@Component({
  selector: 'app-reviews',
  templateUrl: './reviews.component.html',
  styleUrls: ['./reviews.component.css']
})
export class ReviewsComponent implements OnInit {

  reviews: Review[] = [];
  movies: Movie[] = [];
// movie list
  reviewName :any;

  POSTS: any;
  page: number = 1;
  totalRecords: any;
 
 constructor(private reviewService:ReviewService, 
  private movieService:MovieService,
  private router:Router,
  private formBuilder:FormBuilder) {
   this.reviewService = reviewService;
 }
 // populates the data into the Reviews array.
 ngOnInit(): void {
  // init movie list
    this.movieService.getMovies().toPromise().then(
      (reviewData) => { this.movies = reviewData, 
      console.log(this.reviews);
    //inintialize
    this.reviewService.getReviews().subscribe(
      (reviewData) => { this.reviews = reviewData, 
      console.log(this.reviews);
      }
  );
     }
  );
 }

 deleteReview(toDeleteReview : Review) : void {

  if(confirm("Are you sure to delete review of "+this.getMovieName(toDeleteReview.movieId))) {
    this.reviewService.deleteReview(toDeleteReview.reviewId).subscribe(
      (data)=> {
        // remove from array
        this.reviews = this.reviews.filter((employee) => employee != toDeleteReview )
      }
    )
  }

   
 }
 updateReview(id : number) {
   //navigate to edit course comp
   console.log("sending review id to edit from reviews comp:",id);
   this.router.navigate(['edit-review',id]);
 };
 getMovieName(movieId:number): string{
  for(let movie of this.movies) {
    if(movie.movieId === movieId) {
      return movie.movieName;
    }
  }
  return "";
 }
 getMovieUrl(movieId:number): String{
  for(let movie of this.movies) {
    if(movie.movieId === movieId) {
      return movie.movieUrl;
    }
  }
  return "";
 }
}
