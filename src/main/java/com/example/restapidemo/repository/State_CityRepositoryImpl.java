package com.example.restapidemo.repository;

import com.example.restapidemo.domain.City;
import com.example.restapidemo.domain.State_City;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Repository
public class State_CityRepositoryImpl implements State_CityRepository{

    private Map<String, State_City> state_cityMap = new HashMap<>();

    @Override
    public State_City getState_CityById(String id) {
        return state_cityMap.get(id);
    }

    @Override
    public List<State_City> getAllState_City() {
        return state_cityMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Map<String, List<State_City>> getState_CityGroupByState() {
        Map<String, List<State_City>> res = new HashMap<>();
        for(State_City sc : state_cityMap.values()) {
            res.put(sc.getState(), (List<State_City>) sc);
        }
        return res;
    }
    @Override
    public State_City addState_City(State_City state_city){
        state_cityMap.put(state_city.getId(),state_city);
        return null;
    }
    @Override
    public State_City updateState_City(State_City state_city){
        state_cityMap.remove(state_city);
        state_cityMap.put(state_city.getId(),state_city);
        return null;
    }
    @Override
    public State_City deleteState_City(State_City state_city){
        state_cityMap.remove(state_city);
        return null;
    }
}
