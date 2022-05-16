package com.example.springtest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service @Slf4j
public class AsyncService {

    @Async
    public String hello1() {
        for (int i =0; i<10; i++) {
            try {
                Thread.sleep(2000);
                log.info("hello{}", i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Async Hello1 End";
    }

    public String hello2() {
        for (int i =0; i<10; i++) {
            try {
                Thread.sleep(2000);
                log.info("hello{}", i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("hello2 end");
        return "Async Hello2 End";
    }

    @Async("async-thread")
    public CompletableFuture run() {
        return new AsyncResult(hello2()).completable();
    }

}
