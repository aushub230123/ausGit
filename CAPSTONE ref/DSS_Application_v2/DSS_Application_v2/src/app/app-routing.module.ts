import { NgModule } from '@angular/core';
import {  RouterModule, Routes } from '@angular/router';
import { ActorsComponent } from './actors/actors.component';
import { AddActorComponent } from './add-actor/add-actor.component';
import { AddMovieComponent } from './add-movie/add-movie.component';
import { AddReviewComponent } from './add-review/add-review.component';
import { EditActorComponent } from './edit-actor/edit-actor.component';
import { EditMovieComponent } from './edit-movie/edit-movie.component';


import { LoginComponent } from './login/login.component';
import { MoviesComponent } from './movies/movies.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { ReviewsComponent } from './reviews/reviews.component';
import { AuthGuardService } from './service/auth-guard.service';
import { ViewMovieComponent } from './view-movie/view-movie.component';
/*
* Router Module provides the necessary service providers and directives for navigating 
    through application views.

    *
*/


//Routes is an array of Route objects our application supports
const routes: Routes = [
  

  /* Route tells the Angular Router which view to display when a user clicks a link or pastes a URL 
    into the browser address bar. 
    Every Route consists of a path and a component it is mapped to. The Router object parses 
    and builds the final URL using the Route
  */
 //The default route
  {path:'',component:LoginComponent},//The path is empty, indicates the default route. The default route is redirected to the home path using the RedirectTo argument. 
  {path:'login',component:LoginComponent},
  
  {path:'register-user',component:RegisterUserComponent},
  {path:'movies',component:MoviesComponent,canActivate:[AuthGuardService]},//The auth guard is an angular route guard that's used to prevent unauthenticated users from accessing restricted routes
  {path:'actors',component:ActorsComponent,canActivate:[AuthGuardService]},
  {path:'reviews',component:ReviewsComponent,canActivate:[AuthGuardService]},

  {path:'movies/add-movie',component:AddMovieComponent,canActivate:[AuthGuardService]},
  {path:'actors/add-actor',component:AddActorComponent,canActivate:[AuthGuardService]},
  {path:'reviews/add-review',component:AddReviewComponent,canActivate:[AuthGuardService]},

  {path:'edit-movie/:Id',component:EditMovieComponent,canActivate:[AuthGuardService]},
  {path:'edit-actor/:Id',component:EditActorComponent,canActivate:[AuthGuardService]},
  

  {path:'view/:Id',component:ViewMovieComponent,canActivate:[AuthGuardService]},
  {path: '**', component:LoginComponent}, //wild card route
  

]

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
