package com.example.restapidemo.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class State_CityDTO {
    private String id;
    private String name;
    private String state;
    private String description;

    public State_CityDTO(City city) {
        this.id = city.id;
        this.name = city.name;
        this.state = city.state;
        this.description = city.description;

    }
}
