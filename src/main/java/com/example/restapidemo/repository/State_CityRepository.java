package com.example.restapidemo.repository;


import com.example.restapidemo.domain.State_City;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface State_CityRepository {
    State_City getState_CityById(String id);
    List<State_City> getAllState_City();
    Map<String, List<State_City>> getState_CityGroupByState();

    State_City addState_City(State_City state_city);

    State_City updateState_City(State_City state_city);

    State_City deleteState_City(State_City state_city);
}
