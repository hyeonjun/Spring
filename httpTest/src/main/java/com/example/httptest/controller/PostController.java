package com.example.httptest.controller;

import com.example.httptest.dto.AccountRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostController {

    @PostMapping("/post01")
    public void post01(@RequestBody Map<String, Object> requestData) {

        requestData.forEach((key, value) -> {
            System.out.println(key + " = " + value);
        });
    }

    @PostMapping("/post02")
    public void post02(@RequestBody AccountRequest accountRequest) {
        System.out.println(accountRequest.toString());
    }

}
