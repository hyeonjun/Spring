package com.example.client.service;

import com.example.client.dto.Req;
import com.example.client.dto.UserRequest;
import com.example.client.dto.UserResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateService {

    /**
     * GET
     */
    // http://localhost/api/server/user
    // response
    public UserResponse responseUser() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("api/server/res-user")
                .encode()
                .build().toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);

        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());

        return result.getBody();
    }

    public UserResponse paramUser() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("api/server/param-user")
                .queryParam("name", "test")
                .queryParam("age", 20)
                .encode()
                .build().toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);

        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());

        return result.getBody();
    }

    /**
     * POST
     */
    public UserRequest saveUser() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "test") // userId, userName
                .toUri();

        // http body -> object -> object mapper -> json -> rest template -> http body json
        UserRequest req = new UserRequest();
        req.setName("test");
        req.setAge(10);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserRequest> result = restTemplate.postForEntity(uri, req, UserRequest.class);

        System.out.println(result.getStatusCode());
        System.out.println(result.getHeaders());
        System.out.println(result.getBody());
        return result.getBody();
    }

    public UserResponse exchange() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}/exchange")
                .encode()
                .build()
                .expand(100, "test") // userId, userName
                .toUri();
        // http body -> object -> object mapper -> json -> rest template -> http body json
        UserRequest req = new UserRequest();
        req.setName("test");
        req.setAge(10);

        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<UserRequest> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization", "abcd")
                .header("custom-header", "fffff")
                .body(req);
        ResponseEntity<UserResponse> response = restTemplate.exchange(requestEntity, UserResponse.class);
        return response.getBody();
    }

    public Req<UserResponse> genericExchange() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}/generic-exchange")
                .encode()
                .build()
                .expand(100, "test") // userId, userName
                .toUri();
        // http body -> object -> object mapper -> json -> rest template -> http body json

        UserRequest userRequest = new UserRequest();
        userRequest.setName("test");
        userRequest.setAge(10);

        Req<UserRequest> req = new Req<>();
        req.setHeader(
            new Req.Header()
        );

        req.setResponseBody(
                userRequest
        );

        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<Req<UserRequest>> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization", "abcd")
                .header("custom-header", "fffff")
                .body(req);

        ResponseEntity<Req<UserResponse>> response
                = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<>(){});
        return response.getBody();
    }

}
