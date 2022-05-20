package com.example.server.controller;

import com.example.server.dto.Req;
import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/server")
@Slf4j
public class ApiController {

    @GetMapping("/res-user")
    public User responseUser() {
        User user = new User("test", 12);
        return user;
    }

    @GetMapping("/param-user")
    public User paramUser(@RequestParam String name, @RequestParam int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @PostMapping("/user/{userId}/name/{userName}")
    public User signUpUser(@RequestBody User user,
                           @PathVariable int userId,
                           @PathVariable String userName) {
        log.info("client req : {}", user);
        log.info("userId : {}, userName: {}", userId, userName);
        return user;
    }

    @PostMapping("/user/{userId}/name/{userName}/exchange")
    public User exchange(@RequestBody User user,
                         @PathVariable int userId,
                         @PathVariable String userName,
                         @RequestHeader("x-authorization") String authorization,
                         @RequestHeader("custom-header") String customHeader) {
        log.info("client req : {}", user);
        log.info("userId : {}, userName: {}", userId, userName);
        log.info("x-authorization : {}, custom-header : {}", authorization, customHeader);

        return user;
    }

    @PostMapping("/user/{userId}/name/{userName}/generic-exchange")
    public Req<User> genericExchange(@RequestBody Req<User> user,
                                     @PathVariable int userId,
                                     @PathVariable String userName,
                                     @RequestHeader("x-authorization") String authorization,
                                     @RequestHeader("custom-header") String customHeader) {
        log.info("client req : {}", user);
        log.info("userId : {}, userName: {}", userId, userName);
        log.info("x-authorization : {}, custom-header : {}", authorization, customHeader);

        Req<User> response = new Req<>();
        response.setHeader(
                new Req.Header()
        );
        response.setResponseBody(user.getResponseBody());
        return response;
    }

}
