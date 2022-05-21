package com.example.junitspring.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component @RequiredArgsConstructor
public class Calculator {

    private final ICalculator iCalculator;

    public int add(int x, int y) {
        this.iCalculator.init();
        return this.iCalculator.add(x, y);
    }

    public int sub(int x, int y) {
        this.iCalculator.init();
        return this.iCalculator.sub(x, y);
    }


}
