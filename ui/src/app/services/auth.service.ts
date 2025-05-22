import { HttpClient, HttpHeaders } from "@angular/common/http";
import { inject, Injectable } from "@angular/core";
import { BehaviorSubject, map, Observable } from "rxjs";

import { User } from "../models/user";

const headers = new HttpHeaders().set('Accept', 'application/json');

@Injectable({providedIn: 'root'})
export class AuthService {
    url: string = '/api/login'
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
    }
    
}