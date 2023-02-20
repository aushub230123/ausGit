import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

/*The auth guard is an angular route guard that's used to prevent unauthenticated users from accessing restricted routes, 
it does this by implementing the CanActivate interface which allows the guard to decide if a route can be activated 
with the canActivate() method. If the method returns true the route is activated (allowed to proceed), 
otherwise if the method returns false the route is blocked.
*/
export class AuthGuardService implements CanActivate {
//this auth guard is used in app-routing.module.ts to protect the home page route.
  constructor(private router:Router) { }
  canActivate(route: ActivatedRouteSnapshot, 
    state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
    if(sessionStorage.getItem('loggedIn') == 'yes'){
      return true;
    }
    this.router.navigate(['/login'])
    return false;
  }
  
}
