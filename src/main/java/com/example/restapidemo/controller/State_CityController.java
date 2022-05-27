package com.example.restapidemo.controller;

import com.example.restapidemo.domain.State_City;
import com.example.restapidemo.service.State_CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
public class State_CityController {

    private final State_CityService state_cityService;

    @Autowired
    public State_CityController(State_CityService state_cityService) {
        this.state_cityService = state_cityService;
    }

    @GetMapping("/state_ciy/{id}")
    public ResponseEntity<State_City> getState_CityById(@PathVariable String id) {
        return new ResponseEntity<State_City>(state_cityService.getState_CityById(id), HttpStatus.OK);
    }
    @GetMapping("/state_ciy/{state}")
    public ResponseEntity<Map> getState_CityGroupByState() {
        return new ResponseEntity<>(state_cityService.getCityGroupByState(), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<State_City> addState_City(@PathVariable State_City state_city) {
        return new ResponseEntity<State_City>(state_cityService.addState_City(state_city), HttpStatus.OK);
    }
    @PutMapping("")
    public ResponseEntity<State_City> updateState_City(@PathVariable State_City state_city) {
        return new ResponseEntity<State_City>(state_cityService.updateState_City(state_city), HttpStatus.OK);
    }

    @DeleteMapping("/state_city")
    public ResponseEntity<State_City> deleteState_City(@PathVariable State_City state_city) {
        return new ResponseEntity<State_City>(state_cityService.deleteState_City(state_city), HttpStatus.OK);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException() {
        return new ResponseEntity("this is 404 response", HttpStatus.NOT_FOUND);
    }

}
