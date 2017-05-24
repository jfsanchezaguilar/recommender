import { Component } from '@angular/core';
import { NavController, LoadingController } from 'ionic-angular';
import { RecommenderProvider } from "../../providers/recommender/recommender";
import { Ready, Movie, Rating, MovieRating, R1, R2, R3 } from "../../shared/classes";

@Component({
  selector: 'page-about',
  templateUrl: 'about.html'
})
export class AboutPage {

  readySelected: Ready;
  readyRecomendations: Ready[] = [];
  movieRating: MovieRating = new MovieRating(new Rating(), new Movie());
  moviesR1: Movie[] = [];
  moviesR2: Movie[] = [];
  moviesR3: Movie[] = [];
  top5R1: number = 0;
  top10R1: number = 0;
  top5R2: number = 0;
  top10R2: number = 0;
  top5R3: number = 0;
  top10R3: number = 0;

  constructor(public navCtrl: NavController, public loadingCtrl: LoadingController, public recommenderService: RecommenderProvider) {
    
  }

  ionViewWillEnter() {
    let loading = this.loadingCtrl.create({
      content: 'Getting user Movies. Please wait...'
    });
    loading.present();
    this.recommenderService.getReadys().then((readys: Ready[]) => {
      this.readyRecomendations = readys;
      loading.dismiss();
    }, (error) => {
      console.log(error);
      loading.dismiss();
    });
  }

  onReadyChange(event) {
    this.moviesR1 = [];
    this.moviesR2 = [];
    this.moviesR3 = [];
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

  getRecommendations() {
    if (this.readySelected) {
      this.recommenderService.getR1(this.readySelected.id).then((resultsR1: R1[]) => {
        this.moviesR1 = [];
        if (resultsR1.length > 0) {
          this.top5R1 = 0;
          this.top10R1 = 0;
          for (let i = 0; i < 10 && i < resultsR1.length; i++) {
            try {
              let resultR1: R1 = resultsR1[i];
              this.recommenderService.getMovieById(resultR1.movieid).then((movie: Movie) => {
                movie = this.setMovieGeneres(movie);
                this.moviesR1.push(movie);
                this.recommenderService.isMovieInTrainById(resultR1.movieid).then((isTrain: boolean) => {
                  if (isTrain) {
                    if (i < 5)
                      this.top5R1++;
                    this.top10R1++;
                  }
                });
              })
            } catch (error) {
              console.log(error);
            }
          }
        }
        this.recommenderService.getR2(this.readySelected.id).then((resultsR2: R2[]) => {
          this.moviesR2 = [];
          if (resultsR2.length > 0) {
            this.top5R2 = 0;
            this.top10R2 = 0;
            for (let i = 0; i < 10 && i < resultsR2.length; i++) {
              try {
                let resultR2: R2 = resultsR2[i];
                this.recommenderService.getMovieById(resultR2.movieid).then((movie: Movie) => {
                  movie = this.setMovieGeneres(movie);
                  this.moviesR2.push(movie);
                  this.recommenderService.isMovieInTrainById(resultR2.movieid).then((isTrain: boolean) => {
                    if (isTrain) {
                      if (i < 5)
                        this.top5R2++;
                      this.top10R2++;
                    }
                  });
                })
              } catch (error) {
                console.log(error);
              }
            }
          }
          this.recommenderService.getR3(this.readySelected.id).then((resultsR3: R3[]) => {
            this.moviesR3 = [];
            if (resultsR3.length > 0) {
              this.top5R2 = 0;
              this.top10R2 = 0;
              for (let i = 0; i < 10 && i < resultsR3.length; i++) {
                try {
                  let resultR3: R3 = resultsR3[i];
                  this.recommenderService.getMovieById(resultR3.movieid).then((movie: Movie) => {
                    movie = this.setMovieGeneres(movie);
                    this.moviesR3.push(movie);
                    this.recommenderService.isMovieInTrainById(resultR3.movieid).then((isTrain: boolean) => {
                      if (isTrain) {
                        if (i < 5)
                          this.top5R3++;
                        this.top10R3++;
                      }
                    });
                  })
                } catch (error) {
                  console.log(error);
                }
              }
            }
          });
        });
      });
    }
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
