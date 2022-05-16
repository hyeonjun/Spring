package com.example.springtest.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthException extends RuntimeException{

    public AuthException() {
        log.info("Class AuthException");
    }
}
