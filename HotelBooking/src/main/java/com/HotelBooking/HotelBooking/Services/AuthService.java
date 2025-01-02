package com.HotelBooking.HotelBooking.Services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.HotelBooking.HotelBooking.Dtos.AuthResponse;
import com.HotelBooking.HotelBooking.Dtos.LoginData;
import com.HotelBooking.HotelBooking.Dtos.RegisterData;
import com.HotelBooking.HotelBooking.Entities.User;
import com.HotelBooking.HotelBooking.Entities.Enum.Role;
import com.HotelBooking.HotelBooking.Repositories.UserRepository;

@Service
public class AuthService {
    
    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // PasswordEncoder passwordEncoder;

    public AuthResponse register(RegisterData data) {
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
        user.setPassword(data.getPassword()); // Encrypt the password and when we wi
        user.setRole(data.getRole() != null ? data.getRole() : Role.CUSTOMER); // Default role to USER
       // Save the user to the database
        userRepository.save(user);
        return AuthResponse.builder().build();
    }

    public AuthResponse login(LoginData loginData) {
      return AuthResponse.builder().build();
    }
    
}
