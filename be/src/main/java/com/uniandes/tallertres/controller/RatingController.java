package com.uniandes.tallertres.controller;

import com.uniandes.tallertres.entity.Rating;
import com.uniandes.tallertres.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jfsan on 18/05/2017.
 */
@RestController
public class RatingController {
    @Autowired
    private RatingService ratingService;

    public RatingController() {
    }

    @RequestMapping(value = "/rating/user/{id}", method = RequestMethod.GET)
    List<Rating> findByUserId(@PathVariable("id") int id) {
        return ratingService.getRatingsByUserId(id);
    }
}
