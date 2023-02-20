

import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from '../service/authentication.service';
import { catchError, throwError } from 'rxjs';
import { HttpErrorResponse } from '@angular/common/http';


@Component({ 
    templateUrl: 'login.component.html',
    styleUrls:['login.component.css']
})

/*The login component uses the authentication service to login to the application on form submit. 
It creates the form fields and validators using an Angular FormBuilder to 
create an instance of a FormGroup that is stored in the form property. 
The form is then bound to the <form> element in the login component template above using the [formGroup] directive.
*/
export class LoginComponent implements OnInit {
    form: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;
    authenticationStatus: Boolean;
    // loggedIn = false;

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService,

    ) { }

    ngOnInit() {
        this.form = this.formBuilder.group({
            userEmail: ['admin@gmail.com', Validators.required],
            password: ['pass', Validators.required]
        });
    }

    // The component contains a convenience getter property f to make it a bit easier to access form controls
    get f() { return this.form.controls; }

    
    //The login component uses the authentication service to login to the application on form submit.
    onSubmit() {
        this.submitted = true;
        this.loading = true;

        // stop here if form is invalid
        if (this.form.invalid) {
            this.loading = false; //controls the 'spinner-border' property of login button.
            return;
        }

        this.authenticationService.authenticateUser(this.f['userEmail'].value, this.f['password'].value).subscribe(
            (status) => {
                console.log("authenticatiuon status:", status);
                //if authhenticated, navigate to movies component
                if (status) {
                    this.form.reset;
                    sessionStorage.setItem("loggedIn", 'yes')
                    // this.loggedIn = true;
                    this.router.navigate(['movies']);
                }

            }, (error: HttpErrorResponse) => {
                this.loading = false;
                if (error instanceof HttpErrorResponse) {

                    if (error.status === 400) {
                        this.f['userEmail'].setErrors({ userNotRegistered: true });
                        return;
                    } else if (error.status === 406) {
                        this.f['password'].setErrors({ invalidPassword: true });
                        return;
                    }
                }  
                alert("There is a problem with the service.Unable to connect to server. We are notified & working on it. Please try again later.");
                
            });
    }

 
}