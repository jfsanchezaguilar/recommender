import { Component } from '@angular/core';
import { NavController, LoadingController } from 'ionic-angular';
import { RecommenderProvider } from "../../providers/recommender/recommender";
import { Ready } from "../../shared/classes";

@Component({
  selector: 'page-about',
  templateUrl: 'about.html'
})
export class AboutPage {

  readySelected: Ready;
  readyRecomendations: Ready[] = [];

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
}
