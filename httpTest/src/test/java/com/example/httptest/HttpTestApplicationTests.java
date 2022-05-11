package com.example.httptest;

import com.example.httptest.dto.UserReqeust;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HttpTestApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("---------------");

        // Object Mapper
        // Text Json -> Object
        // Object -> Text Json

        // controller req json(text) -> object
        // response object -> json(text)

        var objectMapper = new ObjectMapper();

        // object -> text
        // object mapper는 get method(getter)를 활용함
        var user = new UserReqeust("test", "test@test.com", 10);
        String text = null;
        try {
            text = objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(text);

        // text  -> object
        UserReqeust objectUser = null;
        try {
            objectUser = objectMapper.readValue(text, UserReqeust.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        assert objectUser != null;
        System.out.println(objectUser);
    }

}
