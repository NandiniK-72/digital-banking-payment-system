package com.bank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.LoginRequestDTO;
import com.bank.dto.RegisterRequestDTO;
import com.bank.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(
            AuthService authService) {

        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(

    		@Valid
            @RequestBody
            RegisterRequestDTO request) {

        return ResponseEntity.ok(
                authService.register(request));
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(

            @RequestBody
            LoginRequestDTO request) {

        return ResponseEntity.ok(
                authService.login(request));
    }
}
