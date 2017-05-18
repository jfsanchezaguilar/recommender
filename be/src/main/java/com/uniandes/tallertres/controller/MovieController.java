package com.uniandes.tallertres.controller;

import com.uniandes.tallertres.entity.Movie;
import com.uniandes.tallertres.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jfsan on 17/05/2017.
 */
@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    public MovieController() {

    }

    @RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
    Movie findById(@PathVariable("id") int id) {
        return movieService.getMovie(id);
    }

}
