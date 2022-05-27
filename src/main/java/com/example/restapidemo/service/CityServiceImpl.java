package com.example.restapidemo.service;

import com.example.restapidemo.domain.City;
import com.example.restapidemo.domain.CityDTO;
import com.example.restapidemo.repository.CityRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService{
    private final Log logger = LogFactory.getLog(CityServiceImpl.class);
    private final CityRepository cityRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, RestTemplate restTemplate) {
        this.cityRepository = cityRepository;
        this.restTemplate = restTemplate;
    }


    @Override
    public City getCityById(String id) {
        City cityId = cityRepository.getCityById(id);
        if(cityId == null) {
            throw new RuntimeException(id + ": city not found");
        }
        logger.info(id + "city got.");
        return cityId;
    }

    @Override
    public List<City> getAllCity() {
        return cityRepository
                .getAllCity()
                .stream()
                .map(e -> new City())
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<City>> getCityGroupByState() {
        Map<String, List<City>> res = new HashMap<>();
        for(City city : cityRepository
                .getAllCity()
                .stream()
                .collect(Collectors.toList()) ) {
            res.put(city.getState(), (List<City>) city);
        }
        logger.info("Grouped cities by states:");
        return res;
    }

    @Override
    public City addCity(City city) {
        cityRepository.addCity(city);
        logger.info("City added.");
        return null;
    }

    @Override
    public City updateCity(City city) {
        cityRepository.updateCity(city);
        logger.info("City updated.");
        return null;
    }

    @Override
    public City deleteCity(City city) {
        cityRepository.deleteCity(city);
        logger.info("City removed.");
        return null;
    }

}