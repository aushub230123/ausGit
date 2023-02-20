import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { ViewMovieComponent } from './view-movie/view-movie.component';
import { AddMovieComponent } from './add-movie/add-movie.component';

import { RegisterUserComponent } from './register-user/register-user.component';
import { LoginComponent } from './login/login.component';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { MoviesComponent } from './movies/movies.component';
import { ActorsComponent } from './actors/actors.component';
import { ReviewsComponent } from './reviews/reviews.component';
import { AddActorComponent } from './add-actor/add-actor.component';
import { EditActorComponent } from './edit-actor/edit-actor.component';
import { AddReviewComponent } from './add-review/add-review.component';
import { EditMovieComponent } from './edit-movie/edit-movie.component';

import { FormsModule } from '@angular/forms';
import { Ng2SearchPipeModule } from 'ng2-search-filter';


import { NgxPaginationModule } from 'ngx-pagination';



@NgModule({

  // the declarations state which components belong to this module. 
  declarations: [
    AppComponent,
    HeaderComponent,
    
    ViewMovieComponent,
    AddMovieComponent,
    EditMovieComponent,
    RegisterUserComponent,
    LoginComponent,
    MoviesComponent,
    ActorsComponent,
    ReviewsComponent,
    AddActorComponent,
    EditActorComponent,  
    AddReviewComponent,
  
  ],
  //The imports specify which other angular modules are required by this module
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    Ng2SearchPipeModule,
    NgxPaginationModule,
  

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }


// zz
export class Alert {
  id: string;
  type: AlertType;
  message: string;
  autoClose: boolean;
  keepAfterRouteChange: boolean;
  fade: boolean;

  constructor(init?:Partial<Alert>) {
      Object.assign(this, init);
  }
}

export enum AlertType {
  Success,
  Error,
  Info,
  Warning
}
