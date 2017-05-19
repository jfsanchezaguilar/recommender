package com.uniandes.tallertres.service.impl;

import com.uniandes.tallertres.entity.R1;
import com.uniandes.tallertres.repository.R1Repository;
import com.uniandes.tallertres.service.R1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jfsan on 18/05/2017.
 */
@Service
public class R1ServiceImpl implements R1Service {

    @Autowired
    private R1Repository r1Repository;


    @Override
    public List<R1> getR1ByReadyId(int readyId) {
        return r1Repository.findByReadyId(readyId);
    }
}
