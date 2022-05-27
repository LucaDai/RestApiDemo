package com.example.restapidemo.controller;


import com.example.restapidemo.domain.State;
import com.example.restapidemo.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
public class StateController {

    private final StateService stateService;

    @Autowired
    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping("/state/{id}")
    public ResponseEntity<State> getStateById(@PathVariable String id) {
        return new ResponseEntity<State>(stateService.getStateById(id), HttpStatus.OK);
    }
    @GetMapping("/state/{name}")
    public ResponseEntity<Map> getStateGroupByState() {
        return new ResponseEntity<>(stateService.getCityGroupByState(), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<State> addState_City(@PathVariable State state) {
        return new ResponseEntity<State>(stateService.addState(state), HttpStatus.OK);
    }
    @PutMapping("")
    public ResponseEntity<State> updateState_City(@PathVariable State state) {
        return new ResponseEntity<State>(stateService.updateState(state), HttpStatus.OK);
    }

    @DeleteMapping("/state")
    public ResponseEntity<State> deleteState_City(@PathVariable State state) {
        return new ResponseEntity<State>(stateService.deleteState(state), HttpStatus.OK);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException() {
        return new ResponseEntity("this is 404 response", HttpStatus.NOT_FOUND);
    }
}
