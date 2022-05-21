package com.example.junitspring.controller;

import com.example.junitspring.component.Calculator;
import com.example.junitspring.dto.Req;
import com.example.junitspring.dto.Res;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class CalcApiController {

    private final Calculator calculator;

    @GetMapping("/add")
    public int add(@RequestParam int x, @RequestParam int y) {
        log.info("x: {}, y: {}", x, y);
        return calculator.add(x, y);
    }

    @PostMapping("/sub")
    public Res sub(@RequestBody Req req) {

        int result = calculator.sub(req.getX(), req.getY());
        Res res = new Res();
        res.setResult(result);
        res.setResponse(new Res.Body());
        return res;
    }
}
