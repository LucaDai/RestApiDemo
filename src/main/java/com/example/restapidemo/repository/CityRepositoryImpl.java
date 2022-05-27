package com.example.restapidemo.repository;

import com.example.restapidemo.domain.City;
import com.example.restapidemo.domain.CityDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class CityRepositoryImpl implements CityRepository {

    private Map<String, City> cityMap = new HashMap<>();

    @Override
    public City getCityById(String id) {
        return cityMap.get(id);
    }

    @Override
    public List<City> getAllCity() {
        return cityMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Map<String, List<City>> getCityGroupByState() {
        Map<String, List<City>> res = new HashMap<>();
        for(City city : cityMap.values()) {
            res.put(city.getState(), (List<City>) city);
        }
        return res;
    }
    @Override
    public City addCity(City city){
        cityMap.put(city.getId(),city);
        return null;
    }
    @Override
    public City updateCity(City city){
        cityMap.remove(city);
        cityMap.put(city.getId(),city);
        return null;
    }
    @Override
    public City deleteCity(City city){
        cityMap.remove(city);
        return null;
    }
}