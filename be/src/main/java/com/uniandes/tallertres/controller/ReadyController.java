package com.uniandes.tallertres.controller;

import com.uniandes.tallertres.entity.*;
import com.uniandes.tallertres.service.*;
import com.uniandes.tallertres.util.Recommender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jfsan on 18/05/2017.
 */
@RestController
public class ReadyController {
    @Autowired
    private ReadyService readyService;
    @Autowired
    private R1Service r1Service;
    @Autowired
    private R2Service r2Service;
    @Autowired
    private R3Service r3Service;


    public ReadyController() {
    }

    @RequestMapping(value = "/ready", method = RequestMethod.GET)
    List<Ready> getAllReady() {
        return readyService.getAll();
    }

    @RequestMapping(value= "/ready", method = RequestMethod.POST)
    ResponseEntity<?> addReady(@RequestBody Ready input) {
        Recommender.Recommend(input);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @RequestMapping(value = "/ready/r1/{id}", method = RequestMethod.GET)
    List<R1> getR1ByReadyId(@PathVariable("id") int id) {
        try {
            return r1Service.getR1ByReadyId(id);
        }catch (Exception ex){
            return new ArrayList<R1>();
        }
    }

    @RequestMapping(value = "/ready/r2/{id}", method = RequestMethod.GET)
    List<R2> getR2ByReadyId(@PathVariable("id") int id) {
        try {
            return r2Service.getR2ByReadyId(id);
        }catch (Exception ex){
            return new ArrayList<R2>();
        }
    }

    @RequestMapping(value = "/ready/r3/{id}", method = RequestMethod.GET)
    List<R3> getR3ByReadyId(@PathVariable("id") int id) {
        try {
            return r3Service.getR3ByReadyId(id);
        }catch (Exception ex){
            return new ArrayList<R3>();
        }
    }
}
