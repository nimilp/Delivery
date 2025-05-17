import { HttpClient, HttpHeaders } from "@angular/common/http";
import { inject, Injectable } from "@angular/core";
import { BehaviorSubject, map, Observable } from "rxjs";

import { User } from "../models/user";

const headers = new HttpHeaders().set('Accept', 'application/json');

@Injectable({providedIn: 'root'})
export class AuthService {
    url: string = '/api/login'//'http://localhost:8081/keralakitchn/dummy'
    // $authenticationState = new BehaviorSubject<boolean>(false);
    httpClient = inject(HttpClient)
    
    authenticate(username: string, password: string){
        console.log(username)
        var header = new HttpHeaders(Credential?{
            authorization: 'Basic '+ btoa(username+'+' + password)
        }:{});
        this.httpClient.post(this.url,{header},).subscribe(response => {

            console.log('Here: '+ response)
        })
    
        // this.httpClient.get<User>('/api/dummy',{ headers },).su=>{
        //     if(response !== null){
        //         // this.$authenticationState.next(true)

                
        //         console.log(response.firstName)
        //     } else {
        //         console.log('Error')
        //     }
        // }))
        
    }
    
}