package com.example.junitspring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Res {

    private int result;
    private Body response;

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor
    public static class Body {
        private String resultCode = "OK";
    }
}