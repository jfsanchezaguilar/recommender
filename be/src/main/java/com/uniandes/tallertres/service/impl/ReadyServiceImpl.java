package com.uniandes.tallertres.service.impl;

import com.uniandes.tallertres.entity.Ready;
import com.uniandes.tallertres.repository.ReadyRepository;
import com.uniandes.tallertres.service.ReadyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jfsan on 18/05/2017.
 */
@Service
public class ReadyServiceImpl implements ReadyService{

    @Autowired
    private ReadyRepository readyRepository;

    @Override
    public void addReady(Ready ready) {
        readyRepository.insert(ready);
    }

    @Override
    public List<Ready> getAll() {
        return (List<Ready>) readyRepository.findAll();
    }
}
