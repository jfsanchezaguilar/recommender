import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import { Movie, Rating } from "../../shared/classes";

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

  getRatingsByUserId(userId:number): Promise<Rating[]>{
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

}
