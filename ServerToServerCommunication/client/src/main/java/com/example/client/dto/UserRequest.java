package com.example.client.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter
public class UserRequest {

    private String name;
    private int age;

}
