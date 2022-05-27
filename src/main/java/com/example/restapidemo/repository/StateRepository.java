package com.example.restapidemo.repository;


import com.example.restapidemo.domain.State;
import com.example.restapidemo.domain.State_City;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface StateRepository {
    State getStateById(String id);
    List<State> getAllState();
    Map<String, List<State>> getStateGroupByState();

    State addState(State state);

    State updateState(State state);

    State deleteState(State state);
}
