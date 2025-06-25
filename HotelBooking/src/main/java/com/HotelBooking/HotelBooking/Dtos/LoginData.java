// package com.HotelBooking.HotelBooking.Dtos;

// import jakarta.validation.constraints.Email;
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Size;
// import lombok.Data;
// @Data
// public class LoginData {

//     @NotBlank(message = "Email is mandatory")
//     @Email(message = "Email should be valid")
//     private String email;

//     @NotBlank(message = "Password is mandatory")
//     @Size(min = 8, message = "Password must be at least 8 characters long")
//     private String password;
    
// }
package com.HotelBooking.HotelBooking.Dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginData {

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    // No-argument constructor
    public LoginData() {
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }
}
