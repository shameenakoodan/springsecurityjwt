package com.shameenakoodan.springsecurityjwt.controllers;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponse {
    private String token;

    private long expiresIn;

    public String getToken() {
        return token;
    }

    // Getters and setters...
}

