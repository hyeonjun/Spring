package com.example.server.dto;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Req<T> {

    private Header header;
    private T responseBody;

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
    public static class Header {
        private String responseCode;
    }

}
