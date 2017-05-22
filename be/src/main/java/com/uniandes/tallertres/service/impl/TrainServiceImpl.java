package com.uniandes.tallertres.service.impl;

import com.uniandes.tallertres.entity.R1;
import com.uniandes.tallertres.repository.R1Repository;
import com.uniandes.tallertres.repository.TrainRepository;
import com.uniandes.tallertres.service.R1Service;
import com.uniandes.tallertres.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jfsan on 18/05/2017.
 */
@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainRepository trainRepository;


    @Override
    public boolean isMovieInTrain(int movieId) {
        return trainRepository.countByMovieId(movieId) > 0;
    }
}
