package com.example.restapidemo.service;


import com.example.restapidemo.domain.State_City;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public interface State_CityService {

    State_City getState_CityById(String id) ;

    List<State_City> getAllState_City();

    Map<String, List<State_City>> getCityGroupByState();

    State_City addState_City(State_City state_city);

    State_City updateState_City(State_City state_city);

    State_City deleteState_City(State_City state_city);
}
