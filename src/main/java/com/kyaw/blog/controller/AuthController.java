package com.kyaw.blog.controller;

import com.kyaw.blog.domain.dto.AuthResponse;
import com.kyaw.blog.domain.dto.LoginResponse;
import com.kyaw.blog.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<AuthResponse> login(@RequestBody LoginResponse loginResponse){
        UserDetails userDetails = authService.userLogin(
                loginResponse.email(),
                loginResponse.password());
        String tokenValue = authService.generateToken(userDetails);

        AuthResponse authResponse = AuthResponse.builder()
                .token(tokenValue)
                .expiresIn(86400L)
                .build();
        return  ResponseEntity.ok(authResponse);

    }

}
