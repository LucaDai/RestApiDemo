package com.example.restapidemo.service;

import com.example.restapidemo.domain.State_City;
import com.example.restapidemo.repository.State_CityRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class State_CityServiceImpl implements State_CityService {
    private final Log logger = LogFactory.getLog(State_CityServiceImpl.class);
    private final State_CityRepository state_cityRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public State_CityServiceImpl(State_CityRepository state_cityRepository, RestTemplate restTemplate) {
        this.state_cityRepository = state_cityRepository;
        this.restTemplate = restTemplate;
    }


    @Override
    public State_City getState_CityById(String id) {
        State_City state_cityId = state_cityRepository.getState_CityById(id);
        if(state_cityId == null) {
            throw new RuntimeException(id + ": state_city not found");
        }
        logger.info(id + "state_city got.");
        return state_cityId;
    }

    @Override
    public List<State_City> getAllState_City() {
        return state_cityRepository
                .getAllState_City()
                .stream()
                .map(e -> new State_City())
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<State_City>> getCityGroupByState() {
        Map<String, List<State_City>> res = new HashMap<>();
        for(State_City state_city : state_cityRepository
                .getAllState_City()
                .stream()
                .collect(Collectors.toList()) ) {
            res.put(state_city.getState(), (List<State_City>) state_city);
        }
        logger.info("Grouped cities by states:");
        return res;
    }

    @Override
    public State_City addState_City(State_City city) {
        state_cityRepository.addState_City(city);
        logger.info("City added.");
        return null;
    }

    @Override
    public State_City updateState_City(State_City state_city) {
        state_cityRepository.updateState_City(state_city);
        logger.info("State_city updated.");
        return null;
    }

    @Override
    public State_City deleteState_City(State_City state_city) {
        state_cityRepository.deleteState_City(state_city);
        logger.info("State_city removed.");
        return null;
    }
}
