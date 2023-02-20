import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, MaxValidator, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

import { Movie } from '../models/movie';
import { ActorService } from '../service/actor.service';
import { MovieService } from '../service/movie.service';
import { ReviewService } from '../service/review.service';

@Component({
  selector: 'app-add-review',
  templateUrl: './add-review.component.html',
  styleUrls: ['./add-review.component.css']
})
export class AddReviewComponent implements OnInit {

  movies:Movie[];
  form : FormGroup;
    loading = false;
    submitted = false;
    date;
    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private reviewService: ReviewService,
        private movieService: MovieService
    ) { }

    ngOnInit():void {
      this.date = new Date().toISOString().slice(0, 10);
      this.movieService.getToBeReviewedMovies().subscribe(
        (moviesData) =>{ this.movies = moviesData ,console.log('no review Movies received by Add reviews comp:',moviesData );}
      )
        this.form = this.formBuilder.group({
          reviewId:[],
          datePosted: ['', [Validators.required]],
          rating: ['', [Validators.required,Validators.max(5),Validators.min(1)]],
          description: ['', Validators.required],
          movieId: ['', Validators.required]
        });
       
    }

    // convenience getter for easy access to form fields
    get f() { return this.form.controls; }

    onSubmit() {
        this.submitted = true;
        // stop here if form is invalid
        if (this.form.invalid) {
            return;
        }
        this.loading = true;
        console.log('CreateReview request:',this.form.value);
        this.reviewService.createReview(this.form.value) .subscribe(
          (data) => {console.log('CreateReview response: ', data);
          this.router.navigate(['/reviews']);
        });
        
        }

}
