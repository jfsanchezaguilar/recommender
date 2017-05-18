import { Component } from '@angular/core';
import { NavController, LoadingController } from 'ionic-angular';
import { RecommenderProvider } from "../../providers/recommender/recommender";
import { Rating, Movie, MovieRating } from "../../shared/classes";

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  timerange = {
    lower: 830443285,
    upper: 1474749350
  };
  minDate: Date;
  maxDate: Date;
  minDateIso: string;
  maxDateIso: string;
  userId: number;
  movie: Movie;
  movieRatings: MovieRating[] = [];

  constructor(public navCtrl: NavController, public loadingCtrl: LoadingController, public recommenderService: RecommenderProvider) {
    this.minDate = new Date(0);
    this.minDate.setUTCSeconds(this.timerange.lower);
    this.minDateIso = this.minDate.toISOString();
    this.maxDate = new Date(0);
    this.maxDate.setUTCSeconds(this.timerange.upper);
    this.maxDateIso = this.maxDate.toISOString();
    this.userId = 1;
  }

  onTimeRangeChanged(event: any): void {
    this.minDate = new Date(0);
    this.minDate.setUTCSeconds(this.timerange.lower);
    this.minDateIso = this.minDate.toISOString();
    this.maxDate = new Date(0);
    this.maxDate.setUTCSeconds(this.timerange.upper);
    this.maxDateIso = this.maxDate.toISOString();
  }

  onUserChanged(event: any): void {
    this.movieRatings = [];
    let loading = this.loadingCtrl.create({
      content: 'Getting user Movies. Please wait...'
    });
    loading.present();
    this.recommenderService.getRatingsByUserId(this.userId).then((ratings: Rating[]) => {
      ratings.forEach(rating => {
        this.recommenderService.getMovieById(rating.movieid).then((movie: Movie) => {
          if (movie && movie != null) {
            movie = this.setMovieGeneres(movie);
            let movieRating = new MovieRating(rating, movie);
            this.movieRatings.push(movieRating);
          }
        }, (error) => {
          console.log(error);
        });
      });
      loading.dismiss();
    }, (error) => {
      loading.dismiss();
      console.log(error);
    });
  }

  setMovieGeneres(movie: Movie) : Movie{
    movie.genres = [];
    if (movie.genre1 && movie.genre1 != "")
      movie.genres.push(movie.genre1);
    if (movie.genre2 && movie.genre2 != "")
      movie.genres.push(movie.genre2);
    if (movie.genre3 && movie.genre3 != "")
      movie.genres.push(movie.genre3);
    if (movie.genre4 && movie.genre4 != "")
      movie.genres.push(movie.genre4);
    if (movie.genre5 && movie.genre5 != "")
      movie.genres.push(movie.genre5);
    if (movie.genre6 && movie.genre6 != "")
      movie.genres.push(movie.genre6);
    if (movie.genre7 && movie.genre7 != "")
      movie.genres.push(movie.genre7);
    if (movie.genre8 && movie.genre8 != "")
      movie.genres.push(movie.genre8);

    return movie;
  }
}
