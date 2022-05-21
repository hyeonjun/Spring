package com.example.junitspring.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component @RequiredArgsConstructor
public class DollerCalculator implements ICalculator {

    private int price = 1;
    private final MarketApi marketApi;

    @Override
    public void init() {
        System.out.println("DollerCalculator Init()");
        this.price = marketApi.connect();
    }

    @Override
    public int add(int x, int y) {
        return x * price + y * price;
    }

    @Override
    public int sub(int x, int y) {
        return x * price - y * price;
    }
}
