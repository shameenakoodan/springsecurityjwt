package com.shameenakoodan.springsecurityjwt.dtos;

public class SignupResponseDto {
    private String token;

    public SignupResponseDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
