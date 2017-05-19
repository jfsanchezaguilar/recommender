package com.uniandes.tallertres.service;

import com.uniandes.tallertres.entity.R3;

import java.util.List;

/**
 * Created by jfsan on 18/05/2017.
 */
public interface R3Service {
    List<R3> getR3ByReadyId(int readyId);
}
