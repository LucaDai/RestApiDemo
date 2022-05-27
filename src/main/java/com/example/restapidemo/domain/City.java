package com.example.restapidemo.domain;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
public class City {
    String name;
    String id;
    String state;
    String description;
    private boolean active;

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getState() {
        return state;
    }
    public String getDescription() {
        return description;
    }

}