import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit {
    form : FormGroup;
    loading = false;
    submitted = false;
    
    userMsg:any;
     emailInUse:Boolean ;
     phoneInUse:Boolean;
    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService,
       
    ) { }

    ngOnInit() {
       
        /**
         * (?=.*\d)         should contain at least userEmail digit
         * (?=(.*\W){1})    should contain at least 1 special characters
         * (?=.*[a-z])   should contain at least 1 lower case alphabetic 
         * * (?=.*[A-Z])   should contain at least 1 upper case alphabetic 
         * (?!.*\s)         should not contain any blank space
         * (?=.*[*@!#%&()^~{}]) represents at least one of these  ?=.*[*@!#%&()^~{} charecters
         */
        
        
         let regExprUserName: RegExp = /^[a-zA-Z]*$/; //A pattern string is to be passed to the RegEx constructor object.
         //const phoneNumber = "^((\\+65-?)|0)?[0-9]{10}$";
        this.form = this.formBuilder.group({
            userId:[],
            name: ['test user', [Validators.required,Validators.pattern('^[a-zA-Z, ]*$')]],
            phone: ['12345678', [Validators.required]],
            email: ['test@user', [Validators.required, Validators.email]],
            password: ['Test@1', [Validators.required, Validators.pattern('((?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[*@!#%&()^~{}])).{4,20}')]]
            
        },
         {
           //validators:this.matchRegExpression('name',regExprUserName)
            //validatorsuserEmail:this.matchRegExpressionuserEmail('password',regExprPassword)
         },
            

        );
    }

    // convenience getter for easy access to form fields
    get f() {return this.form.controls}
    
    matchRegExpression(controlName :string,regExp:RegExp){
        return (formGroup:FormGroup)=>{
            const control = formGroup.controls[controlName]; //get the control to be custom validated
            //any errors other than current validation type, return
            if(control.errors && !control.errors['matchRegExpression']){
                return;
            }
            
            console.log("expression returned",regExp.test(control.value));
            if(regExp.test(control.value) == false)//control.value checks with the expression and returns a Boolean value as true or false.
            {
                control.setErrors({matchRegExpression:true}); //{} are used to pass object
            }
            else{
                control.setErrors(null);
            }
        }

    }
    onSubmit() {
        this.submitted = true;
        // stop here if form is invalid
        if (this.form.invalid) {
           // this.submitted = false;
            return;
        }

        console.log('Register user request:',this.form.value);
        this.authenticationService.registerUser(this.form.value)
        .subscribe((data) => {
            console.log('Registered user response: ', data);
            alert("Successfully registered new user.Proceed to login page ");
            this.router.navigate(['/login']);
         },(error: HttpErrorResponse) => {
            if (error instanceof HttpErrorResponse) {

                if (error.status === 400) {
                    this.form.controls['email'].setErrors({ mailAlreadyInUse: true });
                    return;
                } else if (error.status === 406) {
                    this.f['phone'].setErrors({ phoneAlreadyInUse: true });
                    return;
                }
            } 
        });
    }
}
