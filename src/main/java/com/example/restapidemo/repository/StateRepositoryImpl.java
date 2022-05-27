package com.example.restapidemo.repository;

import com.example.restapidemo.domain.State;
import com.example.restapidemo.domain.State_City;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Repository
public class StateRepositoryImpl implements StateRepository{
    private Map<String, State> stateMap = new HashMap<>();

    @Override
    public State getStateById(String id) {
        return stateMap.get(id);
    }

    @Override
    public List<State> getAllState() {
        return stateMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Map<String, List<State>> getStateGroupByState() {
        Map<String, List<State>> res = new HashMap<>();
        for(State state : stateMap.values()) {
            res.put(state.getName(), (List<State>) state);
        }
        return res;
    }
    @Override
    public State addState(State state){
        stateMap.put(state.getId(),state);
        return null;
    }
    @Override
    public State updateState(State state){
        stateMap.remove(state);
        stateMap.put(state.getId(),state);
        return null;
    }
    @Override
    public State deleteState(State state){
        stateMap.remove(state);
        return null;
    }
}
