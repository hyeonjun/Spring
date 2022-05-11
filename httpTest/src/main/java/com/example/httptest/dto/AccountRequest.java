package com.example.httptest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AccountRequest {

    private String account;
    private String email;
    private String address;
    private String password;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("OTP")
    private String OTP;

    @Override
    public String toString() {
        return "AccountRequest{" +
                "account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", OTP='" + OTP + '\'' +
                '}';
    }
}
