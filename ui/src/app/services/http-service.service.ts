import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  httpClient = inject(HttpClient)
  // constructor() { }

  getData(apiUrl: string) {
    return this.httpClient.get(apiUrl).pipe(catchError(this.handleError));
  }

  postData(apiUrl: string, data: any): Observable<any> {
    return this.httpClient.post(apiUrl, data);
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.error('An error occurred:', error.error.message);
    } else {
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    return throwError(
      'Something bad happened; please try again later.');
  }
}
