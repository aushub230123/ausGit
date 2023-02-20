import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Movie } from '../models/movie';
import { MovieService } from '../service/movie.service';
import { FormsModule } from '@angular/forms';
import { Actor } from '../models/actor';
import { Review } from '../models/review';
import { ActorService } from '../service/actor.service';
import { ReviewService } from '../service/review.service';
import { Genre } from '../models/genre';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {

  movies: Movie[] = [];
  actors:Actor[];
  reviews:Review[];
  genres:Genre[];
  formDataLoaded:boolean= false;
  movieName :any;

  POSTS: any;
  page: number = 1;
  totalRecords: any;

  
  constructor(private movieService:MovieService, 
              private actorService:ActorService,
              private reviewService:ReviewService,
              private router:Router,
              private formBuilder:FormBuilder) {
    this.movieService = movieService;
  }
  // populates the data into the Movies array.
  ngOnInit(): void {
    this.formDataLoaded = false;
    //inintialize
    this.reviewService.getReviews().toPromise().then(
      (Data) => { this.reviews = Data, console.log("Reviews received by movies comp init: ",this.reviews);});
      
    this.actorService.getActors().toPromise().then(
      (Data) => { this.actors = Data, console.log("Actors received by movies comp init: ",this.actors);        
    });        
    this.movieService.getGenres().toPromise().then(
      (genreData) => { this.genres = genreData, console.log("Genres received by movies comp init: ",this.genres);});
      
    this.movieService.getMovies().subscribe(
      (Data) => { 
        this.movies = Data;
        this.formDataLoaded = true;
        console.log("Movies received by movies comp init: ",this.movies);
      
      });
  }

  deleteMovie(toDeleteMovie : Movie) : void {
    this.movieService.movieOlderThanOneYear(toDeleteMovie.movieId).subscribe(
      (data)=> {
        if( data == true){
          if(confirm("Are you sure to delete "+toDeleteMovie.movieName)) {
            this.movieService.deleteMovie(toDeleteMovie.movieId).subscribe(
              (data)=> {
                // remove from array
                this.movies = this.movies.filter((movie) => movie != toDeleteMovie )
              });
          }
        }else{
          alert("Movies not older than one year can't be deleted. ");
        }

      }
    );   
  }
  addNewMovie(){
    console.log("Navigating to add-movie comp from list movies");
    this.router.navigate(['add-movie']);
  }
  updateMovie(Id : number) {
    //navigate to edit course comp
    console.log("sending movie id to edit from movies comp:",Id);
    this.router.navigate(['edit-movie',Id]);
  }
 
  getReviewRating(movieId : number)
  {
    for(let review of this.reviews) {
      if(review.movieId === movieId) {
        return review.rating;
      }
    }
    return "-NA-";
  }


  getActorName(actorId : number)
  {
    for(let actor of this.actors) {
      if(actor.actorId === actorId) {
        return actor.firstName + " " + actor.lastName;
      }
    }
    return "";
   }
   getGenreName(genreId : number)
  {
    for(let genre of this.genres) {
      if(genre.genreId === genreId) {
        return genre.name;
      }
    }
    return "";
   }
  
}
