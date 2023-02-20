import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Actor } from '../models/actor';
import { ActorService } from '../service/actor.service';

@Component({
  selector: 'app-edit-actor',
  templateUrl: './edit-actor.component.html',
  styleUrls: ['./edit-actor.component.css']
})
export class EditActorComponent implements OnInit {

  form : FormGroup;
  loading = false;
  submitted = false;
  formDataLoaded: Boolean = false;
  actorId:number;
  actor:Actor;
  

  constructor(
      private formBuilder: FormBuilder,
      private route: ActivatedRoute,
      private router: Router,
      private actorService: ActorService,
      
  ) { }

  ngOnInit() {
    this.formDataLoaded = false;
     //receive movie under edit via router
     this.actorId = this.route.snapshot.params['Id'];
     console.log("actorId  received by Edit actor comp:", this.actorId);
     this.actorService.getActorById(this.actorId)
     .subscribe((Data) => { console.log("Movie data fetched from  server to view:",Data);
         this.actor = Data;
      this.form = this.formBuilder.group({
        'actorId': new FormControl(this.actor.actorId),
        'firstName': new FormControl(this.actor.firstName, Validators.required),
        'lastName': new FormControl(this.actor.lastName, Validators.required),
        'about': new FormControl(this.actor.about, Validators.required),
        'gender': new FormControl(this.actor.gender, Validators.required),
        'age': new FormControl(this.actor.age, [Validators.required, Validators.min(1)]),
        'actorUrl': new FormControl(this.actor.actorUrl, Validators.required)
    
      });
      this.formDataLoaded = true;   

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

      

      console.log('CreateActor request:',this.form.value);
      console.log(" updated Actor details sending to backend:",this.form.value);
      this.actorService.createActor(this.form.value)
      .subscribe((data) => {
        console.log("update actor Response received from  backend:",data);
        this.router.navigate(['/actors']);
    });
      
      }

}
