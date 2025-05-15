import { HttpClient, HttpHeaders } from "@angular/common/http";
import { inject, Injectable } from "@angular/core";
import { BehaviorSubject, map, Observable } from "rxjs";

import { User } from "../models/user";

const headers = new HttpHeaders().set('Accept', 'application/json');

@Injectable({providedIn: 'root'})
export class AuthService {
    url: string = '/api/dummy'//'http://localhost:8081/keralakitchn/dummy'
    // $authenticationState = new BehaviorSubject<boolean>(false);
    httpClient = inject(HttpClient)
    
    authenticate(username: string, password: string){
        console.log(username)
        // this.httpClient.get<User>(this.url).subscribe(response=>{
        //     console.log(response)
        // })
        this.httpClient.get<User>('/api/login',{ headers },).pipe(map((response: User)=>{
            if(response !== null){
                // this.$authenticationState.next(true)

                
                console.log(response.firstName)
            } else {
                console.log('Error')
            }
        }))
        
    }
    
}