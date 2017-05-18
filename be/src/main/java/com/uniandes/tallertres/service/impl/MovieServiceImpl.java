package com.uniandes.tallertres.service.impl;

import com.uniandes.tallertres.repository.MovieRepository;
import com.uniandes.tallertres.entity.Movie;
import com.uniandes.tallertres.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jfsan on 17/05/2017.
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie getMovie(int movieId) {
        List<Movie> movies =  movieRepository.findByMovieId(movieId);
        return movies.size() > 0 ? movies.get(0) : null;
    }
}
