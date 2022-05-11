package com.example.httptest.controller;

import com.example.httptest.dto.PersonRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutController {

    @PutMapping("/put01")
    public void put01(@RequestBody PersonRequest request) {
        System.out.println(request);
    }

    @PutMapping("/put02")
    public PersonRequest put02(@RequestBody PersonRequest request) {
        System.out.println(request);
        return request;
    }

    @PutMapping("/put03/{userId}")
    public PersonRequest put03(@RequestBody PersonRequest request, @PathVariable(name = "userId") Long userId) {
        System.out.println(userId);
        return request;
    }

}
