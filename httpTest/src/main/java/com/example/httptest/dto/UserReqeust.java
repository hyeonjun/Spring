package com.example.httptest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // null 포함 x
public class UserReqeust {

    private String name;
    private String email;
    private Integer age;

    @Override
    public String toString() {
        return "UserReqeust{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    public UserReqeust defaultUser() { // Object Mapper에서 사용되는 클래스에서 getDefaultUser와 같이 get을 붙여 메서드를 만들면 안됨
        return new UserReqeust("default", "default@test.com", 0);
    }
}
