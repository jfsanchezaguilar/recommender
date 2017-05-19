package com.uniandes.tallertres.service;

import com.uniandes.tallertres.entity.R2;

import java.util.List;

/**
 * Created by jfsan on 18/05/2017.
 */
public interface R2Service {
    List<R2> getR2ByReadyId(int readyId);
}
