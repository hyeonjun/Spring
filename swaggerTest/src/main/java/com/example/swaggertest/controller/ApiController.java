package com.example.swaggertest.controller;

import com.example.swaggertest.dto.UserReq;
import com.example.swaggertest.dto.UserRes;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/plus-param/{x}")
    public int plusApiParam(
            @ApiParam(value = "x 값")
            @PathVariable int x,
            @ApiParam(value = "y 값")
            @RequestParam int y) {
        return x + y;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "x", value = "x 값", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "y", value = "y 값", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping("/plus-implict-param/{x}")
    public int plusApiImplicitParam(@PathVariable int x, @RequestParam int y) {
        return x + y;
    }
    
    @ApiResponse(code = 502, message = "사용자의 나이가 10살 이하일 때 502 에러")
    @ApiOperation(value = "사용자 이름과 나이를 반환하는 메소드드")
    @GetMapping("/user")
    public UserRes userGet(UserReq user) {
        return new UserRes(user.getName(), user.getAge());
    }

    @PostMapping("/user")
    public UserRes userPost(@RequestBody UserReq user) {
        return new UserRes(user.getName(), user.getAge());
    }
}
