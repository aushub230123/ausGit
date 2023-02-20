import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, observable, throwError } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
/*The Authentication service handles communication between the Angular app and the backend api for everything related to authentication.
 It contains methods for the login and registration, as well as and standard CRUD methods for retrieving and modifying user data.
*/
export class AuthenticationService {

// perform HTTP requests to the server to carry out CRUD (Create, Read, Update, Delete) operations on data
  //This can be performed using the httpclient service , which is available as an injectable class

  //The HttpClientModule is a service module provided by Angular that 
  //allows us to perform HTTP requests and easily manipulate those requests and their responses.
  //To configure the HttpClientModule and create the authenticate_user service,
  // First, we need to import the HttpClientModule inside the app.module.ts file and then 
  // place it inside imports array: 

  //HttpClient is being injected into AuthenticateUserService using constructor injection.

  baseUrl: string = "http://localhost:8080/api/users"; //end point 
  constructor(private httpClient:HttpClient) {}
  
private handleError(errorResponse:HttpErrorResponse) {
  
  //if the HttpErrorResponse is an instance of ErrorEvent, then it means that a client-side or network error occurred. 
  if(! (errorResponse.error instanceof ErrorEvent))
  {
    console.log("Server side error:"+errorResponse.error.message);
    return throwError('There is a problem with the service.Unable to connect to server. We are notified & working on it. Please try again later.');
    
  }
  //otherwise,a server error occurred.
  else{
    console.log("client side error:"+errorResponse.error.message);
    return (errorResponse);
  }
  // returning a user friendly error message to the consumer of the service.
  



}
  //The service uses the RxJS Observable and Subject classes to enable communication with subscribers
  registerUser(user: User) {
    //post : new emp
    return this.httpClient.post(this.baseUrl, user);
  }

  authenticateUser(email:string,  password:string){
   
      return this.httpClient.get<Observable<Boolean>>(this.baseUrl+"/"+email+"/"+password);
      
     
  }
  signUp( user:User){
   return this.httpClient.post<User>(this.baseUrl,user);
  }

  //("/users/checkEmail/{email}")
  emailInUse(email:string){
    return this.httpClient.get<Boolean>(this.baseUrl+"/checkEmail/"+email);
    }
  phoneInUse(phone:string){
      return this.httpClient.get<Boolean>(this.baseUrl+"/checkPhone/"+phone);
    }

    isValidPassword(email:string,password:string){
      return this.httpClient.get<Boolean>(this.baseUrl+"/checkPassword/"+email+"/"+password);
    }
}
