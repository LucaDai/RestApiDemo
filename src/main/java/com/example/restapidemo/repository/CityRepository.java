package com.example.restapidemo.repository;

import com.example.restapidemo.domain.City;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CityRepository {
    City getCityById(String id);
    List<City> getAllCity();
    Map<String, List<City>> getCityGroupByState();

    City addCity(City city);

    City updateCity(City city);

    City deleteCity(City city);
}