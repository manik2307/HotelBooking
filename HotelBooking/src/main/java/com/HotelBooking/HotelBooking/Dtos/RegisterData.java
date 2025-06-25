// package com.HotelBooking.HotelBooking.Dtos;

// import com.HotelBooking.HotelBooking.Entities.Enum.Role;

// import jakarta.validation.constraints.Email;
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Size;
// import lombok.*;
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class RegisterData {
//     @NotBlank(message = "First Name is mandatory")
//     @Size(min = 2, max = 50, message = "First Name must be between 2 and 50 characters")
//     private String firstName;

//     @NotBlank(message = "Last Name is mandatory")
//     @Size(min = 2, max = 50, message = "Last Name must be between 2 and 50 characters")
//     private String lastName;

//     @NotBlank(message = "Email is mandatory")
//     @Email(message = "Email should be valid")
//     private String email;

//     @NotBlank(message = "Password is mandatory")
//     @Size(min = 8, message = "Password must be at least 8 characters long")
//     private String password;

//     // Role is optional, so no validation annotation
//     private Role role; // Assuming Role is an enum or a class
// }
package com.HotelBooking.HotelBooking.Dtos;

import com.HotelBooking.HotelBooking.Entities.Enum.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterData {

    @NotBlank(message = "First Name is mandatory")
    @Size(min = 2, max = 50, message = "First Name must be between 2 and 50 characters")
    private String firstName;

    @NotBlank(message = "Last Name is mandatory")
    @Size(min = 2, max = 50, message = "Last Name must be between 2 and 50 characters")
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    // Role is optional, so no validation annotation
    private Role role;

    // No-argument constructor
    public RegisterData() {
    }

    // All-argument constructor
    public RegisterData(String firstName, String lastName, String email, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    // Manual builder implementation
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private Role role;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder role(Role role) {
            this.role = role;
            return this;
        }

        public RegisterData build() {
            return new RegisterData(firstName, lastName, email, password, role);
        }
    }
}
