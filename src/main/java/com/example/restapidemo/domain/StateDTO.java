package com.example.restapidemo.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateDTO {
    private String id;
    private String name;
    private String description;

    public StateDTO(State state) {
        this.id = state.id;
        this.name = state.name;
        this.description = state.description;

    }
}
