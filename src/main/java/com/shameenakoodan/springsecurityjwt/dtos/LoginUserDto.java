package com.shameenakoodan.springsecurityjwt.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUserDto {
    private String email;

    private String password;

    // getters and setters here...
}
