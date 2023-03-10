import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  authenticated:Boolean
  ngOnInit(): void {
    if(sessionStorage.getItem('loggedIn') === 'yes')
    {
      this.authenticated = true;
    }else{
      this.authenticated = false;
    }
          
  }
  title = 'DigitalStreamingSystem!';
 
  
constructor(private router:Router){
  
}


  logOut(){
    sessionStorage.setItem("loggedIn",'no');
    this.router.navigate(['login']);
  }
  
}