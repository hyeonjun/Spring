package com.example.client.contoller;

import com.example.client.dto.Req;
import com.example.client.dto.UserRequest;
import com.example.client.dto.UserResponse;
import com.example.client.service.RestTemplateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ApiController {

    private final RestTemplateService restTemplateService;

    public ApiController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping("/res-user")
    public UserResponse resUser() {
        return restTemplateService.responseUser();
    }


    @GetMapping("/req-user")
    public UserResponse reqUser() {
        return restTemplateService.paramUser();
    }

    @PostMapping("/sign-up")
    public UserRequest signUpUser() {
        return restTemplateService.saveUser();
    }

    @PostMapping("/exchange")
    public UserResponse exchange() {
        return restTemplateService.exchange();
    }

    @PostMapping("/generic-exchange")
    public Req<UserResponse> genericExchange() {
        return restTemplateService.genericExchange();
    }

}
