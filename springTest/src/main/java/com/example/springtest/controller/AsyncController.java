package com.example.springtest.controller;

import com.example.springtest.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/async")
@Slf4j
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/hello1")
    public String hello1() {
        asyncService.hello1(); // 비동기 처리하는 메서드이기 때문에 제어권을 넘기지 않음
        return "hello!!!"; // 실행 결과를 바로 넘길 수 있게 됨
    }

    @GetMapping("/hello2") // CompletableFuture: 이후 발생할 실행 결과를 리턴
    public CompletableFuture hello2() { // CompletableFuture를 사용하기 위해서는 request response에 대한 filter인 GlobalFilter 꺼야 함
        log.info("completable future init");
        return asyncService.run();
    }

}
