package com.HotelBooking.HotelBooking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HotelBooking.HotelBooking.Dtos.AuthResponse;
import com.HotelBooking.HotelBooking.Dtos.LoginData;
import com.HotelBooking.HotelBooking.Dtos.RegisterData;
import com.HotelBooking.HotelBooking.Services.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
   @Autowired
    private AuthService authservice;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterData data)
    {
        return ResponseEntity.ok(authservice.register(data));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginUser(@Valid @RequestBody LoginData loginData) {
        return ResponseEntity.ok(authservice.login(loginData));
    }
}
