package com.example.swaggertest.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UserReq {

    @ApiModelProperty(value = "사용자 이름", example = "test", required = true)
    private String name;
    @ApiModelProperty(value = "사용자 나이", example = "10", required = true)
    private int age;
}
