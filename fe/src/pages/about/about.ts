import { Component } from '@angular/core';
import { NavController, LoadingController } from 'ionic-angular';
import { RecommenderProvider } from "../../providers/recommender/recommender";
import { Ready, Movie, Rating, MovieRating } from "../../shared/classes";

@Component({
  selector: 'page-about',
  templateUrl: 'about.html'
})
export class AboutPage {

  readySelected: Ready;
  readyRecomendations: Ready[] = [];
  movieRating: MovieRating = new MovieRating(new Rating(), new Movie());

  constructor(public navCtrl: NavController, public loadingCtrl: LoadingController, public recommenderService: RecommenderProvider) {
    let loading = this.loadingCtrl.create({
      content: 'Getting user Movies. Please wait...'
    });
    loading.present();
    recommenderService.getReadys().then((readys: Ready[]) => {
      this.readyRecomendations = readys;
      loading.dismiss();
    }, (error) => {
      console.log(error);
      loading.dismiss();
    });
  }

  onReadyChange(event) {
    let loading = this.loadingCtrl.create({
      content: 'Getting user Movies. Please wait...'
    });
    loading.present();
    this.recommenderService.getMovieById(this.readySelected.movieid).then((movie: Movie) => {
      this.recommenderService.getRatingsByUserId(this.readySelected.userid).then((ratings: Rating[]) => {
        movie = this.setMovieGeneres(movie);
        let rating = ratings.find(rating => rating.movieid == movie.movieId);
        this.movieRating = new MovieRating(rating, movie);
        loading.dismiss();
      });
    }, (error) => {
      console.log(error);
      loading.dismiss();
    });
  }

  setMovieGeneres(movie: Movie): Movie {
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
