package com.example.junitspring.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

@SpringBootTest // ¸ðµç ºóµéÀÌ ´Ù µî·ÏµÊ
public class DollerCalcTest {

    @MockBean
    private MarketApi marketApi;

    @Autowired
    private Calculator calculator;

    @Test
    public void dollerCalcTest() {
        Mockito.when(marketApi.connect()).thenReturn(3000);

        int add = calculator.add(10, 10);
        int sub = calculator.sub(10, 10);

        Assertions.assertEquals(60000, add);
        Assertions.assertEquals(0, sub);
    }
}
