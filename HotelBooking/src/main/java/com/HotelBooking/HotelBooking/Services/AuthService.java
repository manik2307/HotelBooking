package com.HotelBooking.HotelBooking.Services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.HotelBooking.HotelBooking.Dtos.Auth;
import com.HotelBooking.HotelBooking.Dtos.LoginData;
import com.HotelBooking.HotelBooking.Dtos.RegisterData;
import com.HotelBooking.HotelBooking.Entities.User;
import com.HotelBooking.HotelBooking.Entities.Enum.Role;
import com.HotelBooking.HotelBooking.Repositories.UserRepository;

@Service
public class AuthService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    
    @Autowired
    JWTService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    public Auth register(RegisterData data) {
       //check if the user exists in the databse already then throw erorr
       Optional<User> existingUser = userRepository.findByEmail(data.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("User with this email already exists!");
        }
        // Create a new user entity
        User user = new User();
        user.setFirstName(data.getFirstName());
        user.setLastName(data.getLastName());
        user.setEmail(data.getEmail());
        user.setPassword(passwordEncoder.encode(data.getPassword())); // Encrypt the password and when we wi
        user.setRole(data.getRole() != null ? data.getRole() : Role.CUSTOMER); // Default role to USER
       // Save the user to the database
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        userRepository.save(user);
        return Auth.builder()
            .accessToken(jwtToken)
            .build();
    }

    public Auth login(LoginData request) {
         Optional<User> existingUser = userRepository.findByEmail(request.getEmail());
        if (!existingUser.isPresent()) {
            throw new RuntimeException("User with this email does not exists!");
        }
      authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));
        User user = userRepository.findByEmail(request.getEmail()).get();
        String jwtToken = jwtService.generateToken(user);
        return Auth.builder()
                .accessToken(jwtToken)
                .build();
    }
    public User processOAuthPostLogin(String email, String firstName, String lastName) {
    return userRepository.findByEmail(email).orElseGet(() -> {
        User user = new User();
        user.setEmail(email);
        user.setFirstName(firstName != null ? firstName : "Unknown");
        user.setLastName(lastName != null ? lastName : "User");
        user.setRole(Role.CUSTOMER);
        user.setPassword(""); 
        return userRepository.save(user);
    });
}

public String generateTokenForUser(User user) {
    return jwtService.generateToken(user);
}

}
