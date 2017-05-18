package com.uniandes.tallertres.service;

import com.uniandes.tallertres.entity.Ready;

import java.util.List;

/**
 * Created by jfsan on 18/05/2017.
 */
public interface ReadyService {
    void addReady(Ready ready);
    List<Ready> getAll();
}
