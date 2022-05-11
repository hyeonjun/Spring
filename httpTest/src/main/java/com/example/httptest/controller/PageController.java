package com.example.httptest.controller;

import com.example.httptest.dto.UserReqeust;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main() {
        return "main.html";
    }

    // 잘 사용하지 않음음
   @ResponseBody @GetMapping("/user")
    public UserReqeust user() {
        var user = new UserReqeust();
        user.setName("test");
        user.setEmail("test@test.com");
        return user;
    }

}
