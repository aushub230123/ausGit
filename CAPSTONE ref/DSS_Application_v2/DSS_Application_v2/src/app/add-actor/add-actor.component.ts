import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Actor } from '../models/actor';
import { ActorService } from '../service/actor.service';

@Component({
  selector: 'app-add-actor',
  templateUrl: './add-actor.component.html',
  styleUrls: ['./add-actor.component.css']
})
export class AddActorComponent implements OnInit {

  form : FormGroup;
    loading = false;
    submitted = false;

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private actorService: ActorService,
        
    ) { }

    ngOnInit() {
        this.form = this.formBuilder.group({
          actorId:[],
          firstName: ['', Validators.required],
          lastName: ['', Validators.required],
          about: ['', Validators.required],
          gender: ['', Validators.required],
          age: ['', [Validators.required, Validators.min(1)]],
          actorUrl: ['', Validators.required],
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
        this.actorService.getActorByName(this.f['firstName'].value,this.f['lastName'].value).toPromise().then(
          (data) =>{
            console.log('getActorByName response:',data);
            
            if(data.length !=0 ){
                alert("Duplicate actor name.Actor with this full name is already present.");
                return;
            }
            else{
              console.log('CreateActor request:',this.form.value);

              let fileName:String = this.form.controls['actorUrl'].value;
            fileName = fileName.substr(12,fileName.length);
            fileName = "/assets/"+fileName;
            let actorBeingEdited : Actor = this.form.value;
            actorBeingEdited.actorUrl = fileName;

              this.actorService.createActor(actorBeingEdited)
              .subscribe((data) => {
                console.log('CreateActor response: ', data);
                this.router.navigate(['/actors']);
            });
              
            }
          });
        
        }

}
