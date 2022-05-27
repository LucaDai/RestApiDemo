package com.example.restapidemo.service;



import com.example.restapidemo.domain.State;
import com.example.restapidemo.repository.StateRepository;
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
public class StateServiceImpl implements StateService {
    private final Log logger = LogFactory.getLog(StateServiceImpl.class);
    private final StateRepository stateRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public StateServiceImpl(StateRepository stateRepository, RestTemplate restTemplate) {
        this.stateRepository = stateRepository;
        this.restTemplate = restTemplate;
    }


    @Override
    public State getStateById(String id) {
        State stateId = stateRepository.getStateById(id);
        if(stateId == null) {
            throw new RuntimeException(id + ": state not found");
        }
        logger.info(id + "state got.");
        return stateId;
    }

    @Override
    public List<State> getAllState() {
        return stateRepository
                .getAllState()
                .stream()
                .map(e -> new State())
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<State>> getCityGroupByState() {
        Map<String, List<State>> res = new HashMap<>();
        for(State state : stateRepository
                .getAllState()
                .stream()
                .collect(Collectors.toList()) ) {
            res.put(state.getName(), (List<State>) state);
        }
        logger.info("Grouped cities by states:");
        return res;
    }

    @Override
    public State addState(State state) {
        stateRepository.addState(state);
        logger.info("State added.");
        return null;
    }

    @Override
    public State updateState(State state) {
        stateRepository.updateState(state);
        logger.info("State updated.");
        return null;
    }

    @Override
    public State deleteState(State state) {
        stateRepository.deleteState(state);
        logger.info("State removed.");
        return null;
    }
}
