import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Actor } from '../models/actor';
import { Genre } from '../models/genre';
import { Movie } from '../models/movie';
import { ActorService } from '../service/actor.service';
import { MovieService } from '../service/movie.service';



@Component({
  selector: 'app-add-movie',
  templateUrl: './add-movie.component.html',
  styleUrls: ['./add-movie.component.css']
})
export class AddMovieComponent implements OnInit {

  form : FormGroup;
    loading = false;
    submitted = false;
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

      this.actorService.getActors().subscribe(
        (actorsData) =>{ this.actors = actorsData ,console.log('Actors received by Add Movie comp:',actorsData );}
      )
      this.movieService.getGenres().subscribe(
        (Data) =>{ this.genres = Data ,console.log('Genres received by Add Movie comp:',Data );
      }  ,
      
      )
      this.form = this.formBuilder.group({
        movieId:[],
        movieName: ['', Validators.required],
        actorId: ['', Validators.required],
        duration: ['', [Validators.required,Validators.min(0.1)]],
        overview: ['', Validators.required],
        cost: ['', [Validators.required, Validators.min(1)]],
        genreId:['', Validators.required],
        movieUrl: ['', Validators.required],
        releaseYear: ['', Validators.required],
      });
    }
    saveMovie(){
        console.log('CreateMovie request:',this.form.value);
        let fileName:String = this.form.controls['movieUrl'].value;
       
        // C:\fakepath\
        fileName = fileName.substr(12,fileName.length);
        fileName = "/assets/"+fileName;
        let movieBeingEdited : Movie = this.form.value;
        movieBeingEdited.movieUrl = fileName;
        this.movieService.createMovie(movieBeingEdited)
            .subscribe((data) => {console.log('CreateMovie response: ', data)});
    }

    // convenience getter for easy access to form fields
    get f() { return this.form.controls; }
    navigateToMoviesComp(){
      this.router.navigate(['/movies']);
    }
    onSubmit() {
        this.submitted = true;
        // stop here if form is invalid
        if (this.form.invalid) {
          console.log('CreateMovie movie:Form invalid:' ,this.form.value);
            return;
        }
        this.loading = true;
        this.saveMovie();
        this.navigateToMoviesComp();
        }

}
