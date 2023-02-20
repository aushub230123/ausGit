import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Actor } from '../models/actor';

@Injectable({
  providedIn: 'root'
})
export class ActorService {
  baseUrl : string = "http://localhost:8080/api/v1/actors";
  constructor(private httpClient:HttpClient) {}

  getActors(){
    console.log("productsURL" , this.baseUrl);
    return this.httpClient.get<Actor[]>(this.baseUrl);
    
   }
   getActorById(id: number) {
    //get
    const url :string = this.baseUrl + "/" + id;
    console.log(url);
    return this.httpClient.get<Actor>(url);
  }

  getActorByName(firstName:string,lastName:string){
    console.log("productsURL" , this.baseUrl+"/"+firstName+"/"+lastName);
    return this.httpClient.get<Actor[]>(this.baseUrl+"/"+firstName+"/"+lastName);
  }

  createActor(actor: Actor) {
    //post : new emp
    return this.httpClient.post(this.baseUrl, actor);
  }
  updateActor(actorId:number, actor:any) : Observable<Object> {
    //put : update emp
    return this.httpClient.put(`${this.baseUrl}/${actorId}`, actor);
  }
  deleteActor(id: number) {
    //post
    return this.httpClient.delete<Actor>(this.baseUrl + "/" + id);
  }
}
