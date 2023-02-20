import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Actor } from '../models/actor';
import { Genre } from '../models/genre';
import { Movie } from '../models/movie';
import { ActorService } from '../service/actor.service';
import { MovieService } from '../service/movie.service';



@Component({
  selector: 'app-edit-movie',
  templateUrl: './edit-movie.component.html',
  styleUrls: ['./edit-movie.component.css']
})
export class EditMovieComponent implements OnInit {

   movieId:number;
   movie:Movie;
   
  
  editForm : FormGroup;
    loading = false;
    submitted = false;
    formDataLoaded: Boolean = false;
    actors:Actor[];
    genres:Genre[];
    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private movieService: MovieService,
        private actorService: ActorService,
        
        
    ) { }
    ngOnInit() {
      this.formDataLoaded = false;
        //receive movie under edit via router
      this.movieId = this.route.snapshot.params['Id'];
      console.log("Movie id received by Edit movie comp:", this.movieId);
  

      this.actorService.getActors().toPromise()
      .then((actorsData) =>{ this.actors = actorsData ,console.log('Actors received by Add Movie comp:',actorsData );      
      });
      
      this.movieService.getGenres().toPromise()
      .then((Data) =>{ this.genres = Data ,console.log('Genres received by Add Movie comp:',this.genres );
      });

      this.movieService.getMovieById(this.movieId)
      .subscribe((movieData) => { console.log("Movie data fetched from  server to view:",movieData);
          this.movie = movieData;

          this.editForm = this.formBuilder.group({
            'movieId': new FormControl(this.movie.movieId),
            'movieName': new FormControl(this.movie.movieName,Validators.required),
            'actorId':new FormControl(this.movie.actorId, Validators.required),
            'duration': new FormControl(this.movie.duration, [Validators.required,Validators.min(1)]),
            'overview': new FormControl(this.movie.overview, Validators.required),
            'cost': new FormControl(this.movie.cost, [Validators.required, Validators.min(1)]),
            'genreId':new FormControl(this.movie.genreId, Validators.required),
            'movieUrl': new FormControl(this.movie.movieUrl, Validators.required),
            'releaseYear': new FormControl(this.movie.releaseYear, Validators.required)
          });
          this.formDataLoaded = true;   

      });
      
        
        
      
    }
 
    // convenience getter for easy access to form fields
    get f() { return this.editForm.controls; }

    updateMovie() {
      this.submitted = true;
      // stop here if form is invalid
      if (this.editForm.invalid) {
        return;
    }
    this.loading = true;
      console.log(" updated Movie details sending to backend:",this.editForm.value);
      this.movieService.updateMovie(this.movieId,this.editForm.value)
      .toPromise()
      .then((data => {
        console.log("update movie Response received from  backend:",data);
        this.movie = new Movie();
        this.router.navigate(['/movies']);
      }));
      
  }

}

  
function movieData(movieData: any) {
  throw new Error('Function not implemented.');
}

