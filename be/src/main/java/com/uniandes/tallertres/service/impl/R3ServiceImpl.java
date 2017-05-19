package com.uniandes.tallertres.service.impl;

import com.uniandes.tallertres.entity.R3;
import com.uniandes.tallertres.repository.R3Repository;
import com.uniandes.tallertres.service.R3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jfsan on 18/05/2017.
 */
@Service
public class R3ServiceImpl implements R3Service {

    @Autowired
    private R3Repository r3Repository;


    @Override
    public List<R3> getR3ByReadyId(int readyId) {
        return r3Repository.findByReadyId(readyId);
    }
}
