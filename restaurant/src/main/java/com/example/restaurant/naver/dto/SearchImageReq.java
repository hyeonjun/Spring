package com.example.restaurant.naver.dto;

import lombok.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class SearchImageReq {

    private String query = "";
    private int display = 1;
    private int start = 1;

    private String sort = "sim";

    private String filter = "all";

    public MultiValueMap<String, String> multiValueMap () {
        var map = new LinkedMultiValueMap<String, String>();
        map.add("query", query);
        map.add("display", String.valueOf(display));
        map.add("start", String.valueOf(start));
        map.add("sort", sort);
        map.add("filter", filter);
        return map;
    }
}
