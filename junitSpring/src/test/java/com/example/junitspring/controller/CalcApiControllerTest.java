package com.example.junitspring.controller;

import com.example.junitspring.component.Calculator;
import com.example.junitspring.component.DollerCalculator;
import com.example.junitspring.component.MarketApi;
import com.example.junitspring.dto.Req;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest(CalcApiController.class) // CalcApiController.class에 대해서만 테스트할 것이기 때문에 이 클래스에 필요한 빈들만 등록됨
@AutoConfigureMockMvc
@Import({Calculator.class, DollerCalculator.class})
public class CalcApiControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @MockBean
    private MarketApi marketApi;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Mockito.when(marketApi.connect()).thenReturn(3000);
    }

    @Test
    public void addTest() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8080/api/add")
                        .queryParam("x", "10")
                        .queryParam("y", "10")
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("60000"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void subTest() throws Exception {
        Req req = new Req();
        req.setX(10);
        req.setY(10);

        String json = new ObjectMapper().writeValueAsString(req);

        mockMvc.perform(
                MockMvcRequestBuilders.post("http://localhost:8080/api/sub")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("0"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.response.resultCode").value("OK"))
                .andDo(MockMvcResultHandlers.print());
    }
}
