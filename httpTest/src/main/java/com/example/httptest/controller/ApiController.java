package com.example.httptest.controller;

import com.example.httptest.dto.UserReqeust;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    // Text
    @GetMapping("/text")
    public String text(@RequestParam String account) {
        return account;
    }

    // JSON
    // request -> Object mapper -> object -> method -> object -> object mapper -> json -> response
    @PostMapping("/json")
    public UserReqeust json(@RequestBody UserReqeust reqeust) {
        return reqeust; // 200 OK
    }

    @PutMapping("/put")
    public ResponseEntity<UserReqeust> put(@RequestBody UserReqeust reqeust) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reqeust); // 201 OK
    }



}
