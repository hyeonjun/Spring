package com.example.navermapapi.controller;

import com.example.navermapapi.service.RestTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final RestTemplateService restTemplateService;

    @GetMapping("/naver/{search}")
    public String naver(@PathVariable("search") String query) {
        return restTemplateService.naver(query);
    }
}
