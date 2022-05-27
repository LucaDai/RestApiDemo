package com.example.restapidemo.controller;

import com.example.restapidemo.domain.City;
import com.example.restapidemo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/city/{id}")
    public ResponseEntity<City> getCityById(@PathVariable String id) {
        return new ResponseEntity<City>(cityService.getCityById(id), HttpStatus.OK);
    }
    @GetMapping("/city/{state}")
    public ResponseEntity<Map> getCityGroupByState() {
        return new ResponseEntity<>(cityService.getCityGroupByState(), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<City> addCity(@PathVariable City city) {
        return new ResponseEntity<City>(cityService.addCity(city), HttpStatus.OK);
    }
    @PutMapping("")
    public ResponseEntity<City> updateCity(@PathVariable City city) {
        return new ResponseEntity<City>(cityService.updateCity(city), HttpStatus.OK);
    }

    @DeleteMapping("/city")
    public ResponseEntity<City> deleteCity(@PathVariable City city) {
        return new ResponseEntity<City>(cityService.deleteCity(city), HttpStatus.OK);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException() {
        return new ResponseEntity("this is 404 response", HttpStatus.NOT_FOUND);
    }


}