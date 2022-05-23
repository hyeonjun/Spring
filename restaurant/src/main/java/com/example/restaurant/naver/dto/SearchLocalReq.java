package com.example.restaurant.naver.dto;

import lombok.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class SearchLocalReq {

    private String query = "";
    private int display = 1;
    private int start = 1;

    private String sort = "random";

    public MultiValueMap<String, String> multiValueMap () {
        var map = new LinkedMultiValueMap<String, String>();
        map.add("query", query);
        map.add("display", String.valueOf(display));
        map.add("start", String.valueOf(start));
        map.add("sort", sort);
        return map;
    }
}
