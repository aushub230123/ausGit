import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  authenticated = false;
  constructor() { }

  ngOnInit(): void {
    if(sessionStorage.getItem('loggedIn') === 'yes')
    {
      this.authenticated = true;
    }else{
      this.authenticated = false;
    }
        console.log("Authenticated : " + this.authenticated)
  }
}
