package com.uniandes.tallertres.service;

import com.uniandes.tallertres.entity.Rating;

import java.util.List;

/**
 * Created by jfsan on 18/05/2017.
 */
public interface RatingService {
    List<Rating> getRatingsByUserId(int userId);
}
