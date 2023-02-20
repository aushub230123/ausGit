import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Movie } from 'src/app/models/movie';
import { Genre } from '../models/genre';

@Injectable({
  providedIn: 'root'
})
export class MovieService {
  genreUrl : string = "http://localhost:8080/api/v1/genres";
  baseUrl : string = "http://localhost:8080/api/v1/movies";
  moviesToBeReviewedUrl : string = "http://localhost:8080/api/v1/movies/noReviews";
    constructor(private httpClient:HttpClient) {}

    getMovies(){
      console.log("Movies url" , this.baseUrl);
      return this.httpClient.get<Movie[]>(this.baseUrl);
     }

     getToBeReviewedMovies(){
      console.log("To be reviewed Movies url" , this.moviesToBeReviewedUrl);
      return this.httpClient.get<Movie[]>(this.moviesToBeReviewedUrl);
     }
     //withActor
     getMoviesByActor(id:number){
      console.log(" Movies by actor url:" , this.baseUrl + "/withActor/" + id);
      return this.httpClient.get<Movie[]>(this.baseUrl + "/withActor/" + id);
     }

     movieOlderThanOneYear(id:number){
      console.log(" movieOlderThanOneYear url:" , this.baseUrl + "/checkForOneYearOld/" + id);
      return this.httpClient.get<Boolean>(this.baseUrl + "/checkForOneYearOld/" + id);
     }

     getGenres(){
      console.log("URL genres" , this.genreUrl);
      return this.httpClient.get<Genre[]>(this.genreUrl);
     }
     getMovieById(id: number) {
      //get
      const url :string = this.baseUrl + "/" + id;
      console.log(url);
      return this.httpClient.get<Movie>(url);
    }
    createMovie(employee: Movie) {
      //post : new emp
      return this.httpClient.post(this.baseUrl, employee);
    }
    updateMovie(movieId:number, movie:any) : Observable<Object> {
      //put : update emp
      return this.httpClient.put(`${this.baseUrl}/${movieId}`, movie);
    }
    deleteMovie(id: number) {
      //post
      return this.httpClient.delete<Movie>(this.baseUrl + "/" + id);
    }
  }

    
