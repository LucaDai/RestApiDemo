package com.example.restapidemo.service;

import com.example.restapidemo.domain.City;
import com.example.restapidemo.domain.CityDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface CityService {


    City getCityById(String id) ;

    List<City> getAllCity();

    Map<String, List<City>> getCityGroupByState();

    City addCity(City city);

    City updateCity(City city);

    City deleteCity(City city);
}

