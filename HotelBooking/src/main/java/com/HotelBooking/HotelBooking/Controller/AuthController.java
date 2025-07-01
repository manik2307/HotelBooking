package com.HotelBooking.HotelBooking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HotelBooking.HotelBooking.Dtos.Auth;
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
    public ResponseEntity<Auth> register(@Valid @RequestBody RegisterData data)
    {
        Auth a=authservice.register(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(a);
    }

    @PostMapping(value = "/login", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<Auth> loginUser(@Valid @RequestBody LoginData loginData) {
        return ResponseEntity.ok(authservice.login(loginData));
    }
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello, you are authenticated!");
    }   

    @PostMapping("/form-login")
    public String formLogin(@RequestParam String email, @RequestParam String password, Model model) {
    LoginData loginData = new LoginData(email, password);
    try {
        authservice.login(loginData); // This will throw if credentials are wrong
        return "redirect:/";
    } catch (Exception e) {
        model.addAttribute("loginError", "Invalid email or password");
        SecurityContextHolder.clearContext();
        return "NotAuthenticated";
    }
}
}
