import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import 'rxjs/add/operator/catch';
import { Movie, Rating, Ready, R1, R2, R3 } from "../../shared/classes";

/*
  Generated class for the RecommenderProvider provider.

  See https://angular.io/docs/ts/latest/guide/dependency-injection.html
  for more info on providers and Angular 2 DI.
*/
@Injectable()
export class RecommenderProvider {

  private apiUrl: string = "http://localhost:8080/";

  constructor(public http: Http) {
    console.log('Hello RecommenderProvider Provider');
  }

  getRatingsByUserId(userId: number): Promise<Rating[]> {
    return new Promise((resolve, reject) => {
      this.http.get(this.apiUrl + "rating/user/" + userId)
        .map(res => res.json())
        .subscribe(data => {
          resolve(data);
        }, error => {
          reject(error);
        });
    });
  }

  getMovieById(movieId: number): Promise<Movie> {
    return new Promise((resolve, reject) => {
      this.http.get(this.apiUrl + "movie/" + movieId)
        .map(res => res.json())
        .subscribe(data => {
          resolve(data);
        }, error => {
          reject(error);
        });
    });
  }

  getReadys(): Promise<Ready[]> {
    return new Promise((resolve, reject) => {
      this.http.get(this.apiUrl + "ready")
        .map(res => res.json())
        .subscribe(data => {
          resolve(data);
        }, error => {
          reject(error);
        });
    });
  }

  postReady(ready: Ready): Promise<Ready> {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    let readyStr = JSON.stringify(ready);
    return this.http.post(this.apiUrl + "/ready", readyStr, options).toPromise()
      .then(this.extractData)
      .catch(this.handleError);
  }

  getR1(readyId: number): Promise<R1[]> {
    return new Promise((resolve, reject) => {
      this.http.get(this.apiUrl + "ready/r1/" + readyId)
        .map(res => res.json())
        .subscribe(data => {
          resolve(data);
        }, error => {
          reject(error);
        });
    });
  }

  getR2(readyId: number): Promise<R2[]> {
    return new Promise((resolve, reject) => {
      this.http.get(this.apiUrl + "ready/r2/" + readyId)
        .map(res => res.json())
        .subscribe(data => {
          resolve(data);
        }, error => {
          reject(error);
        });
    });
  }

  getR3(readyId: number): Promise<R3[]> {
    return new Promise((resolve, reject) => {
      this.http.get(this.apiUrl + "ready/r3/" + readyId)
        .map(res => res.json())
        .subscribe(data => {
          resolve(data);
        }, error => {
          reject(error);
        });
    });
  }

  private extractData(res: Response) {
    let body = res.json();
    return body || {};
  }

  private handleError(error: Response | any) {
    // In a real world app, we might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Promise.reject(errMsg);
  }

}
