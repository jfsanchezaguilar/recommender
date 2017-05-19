package com.uniandes.tallertres.controller;

import com.uniandes.tallertres.entity.*;
import com.uniandes.tallertres.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return null;
    }

    @RequestMapping(value= "/ready", method = RequestMethod.POST)
    ResponseEntity<?> addReady(@RequestBody Ready input) {
        this.readyService.addReady(input);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @RequestMapping(value = "/ready/r1/{id}", method = RequestMethod.GET)
    List<R1> getR1ByReadyId(@PathVariable("id") int id) {
        return r1Service.getR1ByReadyId(id);
    }

    @RequestMapping(value = "/ready/r2/{id}", method = RequestMethod.GET)
    List<R2> getR2ByReadyId(@PathVariable("id") int id) {
        return r2Service.getR2ByReadyId(id);
    }

    @RequestMapping(value = "/ready/r3/{id}", method = RequestMethod.GET)
    List<R3> getR3ByReadyId(@PathVariable("id") int id) {
        return r3Service.getR3ByReadyId(id);
    }
}
