package com.example.day3sms.controller;

import com.example.day3sms.dto.LoginRequestDTO;
import com.example.day3sms.dto.RegisterRequestDTO;
import com.example.day3sms.dto.TokenResponseDTO;
import com.example.day3sms.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService service;
    private AuthController(AuthService service){
        this.service=service;
    }
    @PostMapping("/login")
    public TokenResponseDTO login(@RequestBody LoginRequestDTO dto){
        return service.login(dto);
    }
    @PostMapping("/register")
    public TokenResponseDTO register(@Valid @RequestBody RegisterRequestDTO dto){
        return service.register(dto);
    }
}
