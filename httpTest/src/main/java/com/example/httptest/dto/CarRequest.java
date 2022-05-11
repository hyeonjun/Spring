package com.example.httptest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CarRequest {

    private String name;

    @JsonProperty("car_number")
    private String carNumber;

    @Override
    public String toString() {
        return "CarRequest{" +
                "name='" + name + '\'' +
                ", number='" + carNumber + '\'' +
                '}';
    }
}
