package com.uniandes.tallertres.service.impl;

import com.uniandes.tallertres.entity.R2;
import com.uniandes.tallertres.repository.R2Repository;
import com.uniandes.tallertres.service.R2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jfsan on 18/05/2017.
 */
@Service
public class R2ServiceImpl implements R2Service {

    @Autowired
    private R2Repository r2Repository;


    @Override
    public List<R2> getR2ByReadyId(int readyId) {
        return r2Repository.findByReadyId(readyId);
    }
}
