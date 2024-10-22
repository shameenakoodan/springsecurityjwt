package com.shameenakoodan.springsecurityjwt.controllers;

import com.shameenakoodan.springsecurityjwt.dtos.LoginUserDto;
import com.shameenakoodan.springsecurityjwt.dtos.RegisterUserDto;
import com.shameenakoodan.springsecurityjwt.dtos.SignupResponseDto;
import com.shameenakoodan.springsecurityjwt.entity.User;
import com.shameenakoodan.springsecurityjwt.exceptions.UserAlreadyExistsException;
import com.shameenakoodan.springsecurityjwt.services.AuthenticationService;
import com.shameenakoodan.springsecurityjwt.services.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody RegisterUserDto registerUserDto) {
        try {
            // Register the user
            User registeredUser = authenticationService.signup(registerUserDto);

            // Generate a JWT token for the registered user
            String token = jwtService.generateToken(registeredUser);

            // Return the token in the response wrapped in SignupResponse
            return ResponseEntity.ok(new SignupResponseDto(token));
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
        }
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
