package com.example.restapidemo.service;

import com.example.restapidemo.domain.State;
import com.example.restapidemo.domain.State_City;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public interface StateService {
    State getStateById(String id) ;

    List<State> getAllState();

    Map<String, List<State>> getCityGroupByState();

    State addState(State state);

    State updateState(State state);

    State deleteState(State state);
}
