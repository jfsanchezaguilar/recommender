package com.uniandes.tallertres.service.impl;

import com.uniandes.tallertres.entity.Rating;
import com.uniandes.tallertres.repository.RatingRepository;
import com.uniandes.tallertres.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jfsan on 18/05/2017.
 */
@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public List<Rating> getRatingsByUserId(int userId) {
        return ratingRepository.findByUserId(userId);
    }
}
