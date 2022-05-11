package com.example.httptest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PersonRequest {

    private String name;
    private int age;
    private List<CarRequest> carList;

    @Override
    public String toString() {
        return "PersonRequest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", carList=" + carList +
                '}';
    }
}
