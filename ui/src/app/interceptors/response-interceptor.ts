import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, tap } from "rxjs";

@Injectable()
export class ResponseInterceptor implements HttpInterceptor {
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        // 
        console.log(request)
        return next.handle(request).pipe(
            tap(event => {
                console.log('Event: ',event)
                if (event instanceof HttpResponse) {
                    
                    console.log('Response received:', event);
                }
                if(event instanceof HttpRequest) {
                    console.log('Request', event);
                }
            })
        );
    }

}