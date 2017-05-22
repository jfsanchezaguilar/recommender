export class Movie {
    movieId: number;
    title: string;
    genres: string[];
    genre1: string;
    genre2: string;
    genre3: string;
    genre4: string;
    genre5: string;
    genre6: string;
    genre7: string;
    genre8: string;

    constructor() {

    }
}

export class Rating {
    id: number;
    timestamp: number;
    movieid: number;
    rating: number;
    userid: number;

    constructor() {

    }
}

export class MovieRating {
    rating: Rating;
    movie: Movie;

    constructor(rating: Rating, movie: Movie) {
        this.movie = movie;
        this.rating = rating;
    }
}

export class Ready {

    id: number;
    timestampfrom: number;
    timestampto: number;
    movieid: number;
    userid: number;
    ready: boolean;

    constructor(){
        
    }

}

export class R1 {

    id: number;
    userid: number;
    movieid: number;
    readyid: number;

    constructor() {

    }
}

export class R2 {
    id: number;
    movieid: number;
    readyid: number;

    constructor() {

    }
}

export class R3 {
    id: number;
    movieid: number;
    readyid: number;

    constructor() {

    }
}