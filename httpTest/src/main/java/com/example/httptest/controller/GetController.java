package com.example.httptest.controller;

import com.example.httptest.dto.UserReqeust;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController // 해당 Class 는 REST API를 처리하는 Controller
@RequestMapping("api") // URI를 지정해주는 어노테이션
public class GetController {

    @GetMapping("/hello") // http://localhost:9090/api/hello
    public String hello() {
        return "hello spring boot!";
    }

    @GetMapping(path = "/hi")
    public String hi() {
        return "hi spring boot";
    }

    @RequestMapping("/hihello") // get / post / put / delete
    public String hihello() {
        return "hi hello";
    }

    @RequestMapping(path = "/get-hihello", method = RequestMethod.GET) // get, http://localhost:9090/api/get-hihello
    public String getHiHello() {
        return "hi hello";
    }

    @GetMapping("/path-variable/{name}") // http://localhost:9090/api/path-variable/{name}
    public String pathVariable(@PathVariable(name = "name") String pathName) {
        System.out.println("PathVariable : "+ pathName);
        return pathName;
    }

    // query parameter
    // http://localhost:9090/api/query-param?user=steve&email=eteve@gamil.com&age=20
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {

        StringBuilder sb = new StringBuilder();

        queryParam.forEach((key, value) -> {
            System.out.println(key + " = " + value);

            sb.append(key).append(" = ").append(value).append("\n");
        });
        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParam02 (@RequestParam String name, @RequestParam String email, @RequestParam int age) {
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return name + " " + email + " " + age;
    }

    // user=steve&email=eteve@gamil.com&age=20 가 들어오게 되면
    // 키에 해당하는 명들과 UserRequest의 변수명이 매칭이 되어 값이 저장됨
    @GetMapping("query-param03")
    public String queryParam03 (UserReqeust userReqeust) {
        System.out.println(userReqeust.getName());
        System.out.println(userReqeust.getEmail());
        System.out.println(userReqeust.getAge());
        return userReqeust.toString();
    }


}
