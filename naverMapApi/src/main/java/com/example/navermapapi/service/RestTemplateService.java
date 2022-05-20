package com.example.navermapapi.service;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.StandardCharsets;

@Service
public class RestTemplateService {

    public String naver(String query) {
        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/local.json")
                .queryParam("query", query)
                .queryParam("display", 10)
                .queryParam("start", 1)
                .queryParam("sort", "random")
                .encode(StandardCharsets.UTF_8)
                .build()
                .toUri();
        RestTemplate restTemplate = new RestTemplate();

        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id", "")
                .header("X-Naver-Client-Secret", "")
                .build();

        ResponseEntity<String> result = restTemplate.exchange(req, String.class);

        return result.getBody();
    }

}
