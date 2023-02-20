import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Movie } from '../models/movie';
import { MovieService } from '../service/movie.service';

@Component({
  selector: 'app-view-movie',
  templateUrl: './view-movie.component.html',
  styleUrls: ['./view-movie.component.css']
})
export class ViewMovieComponent implements OnInit {

  movieId:number
  movie:Movie
  constructor( private route : ActivatedRoute, private router: Router,private movieService:MovieService) { }

  ngOnInit(): void {
    this.movieId = this.route.snapshot.params['Id'];
    console.log("Movie id received by view movie comp:", this.movieId);
    this.movieService.getMovieById(this.movieId).subscribe(
     
      (movieData) => { 
      console.log("Movie data fetched from backend to view:",movieData);
      this.movie = movieData;
    }, (error)=> { console.log("error : " , error) }
    )
  }




}
