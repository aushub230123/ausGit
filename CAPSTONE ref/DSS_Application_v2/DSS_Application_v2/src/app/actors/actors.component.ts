import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Actor } from '../models/actor';
import { ActorService } from '../service/actor.service';
import { MovieService } from '../service/movie.service';

@Component({
  selector: 'app-actors',
  templateUrl: './actors.component.html',
  styleUrls: ['./actors.component.css']
})
export class ActorsComponent implements OnInit {

  actors: Actor[] = [];
  
  actorName :any;
  POSTS: any;
  page: number = 1;
  totalRecords: any;

 
 constructor(private actorService:ActorService, 
  private movieService:MovieService,
  private router:Router,private formBuilder:FormBuilder) {
   this.actorService = actorService;
 }
 // populates the data into the Actors array.
 ngOnInit(): void {
   //inintialize
   this.actorService.getActors().subscribe(
     (actorData) => { this.actors = actorData, 
     console.log(this.actors);
      }
   );
 }
 deleteActor(toDeleteActor : Actor) : void {
  this.movieService.getMoviesByActor(toDeleteActor.actorId).toPromise().then(
    (data)=> {
      if(data.length == 0 ){

        if(confirm("Are you sure to delete "+toDeleteActor.firstName + " " + toDeleteActor.lastName)) {
          this.actorService.deleteActor(toDeleteActor.actorId).subscribe(
            (data)=> {
              // remove from array
              this.actors = this.actors.filter((actor) => actor != toDeleteActor ); });
        }

        
      }
      else{
        alert("Sorry!Actor can not  be deleted as he/she is associated with  movies!");
        return;
      }
    }
  )

   
 }
 updateActor(id : number) {
   //navigate to edit course comp
   console.log("sending actor id to edit from actors comp:",id);
   this.router.navigate(['edit-actor',id]);
 }

 
}
