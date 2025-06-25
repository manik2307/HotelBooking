package com.HotelBooking.HotelBooking.Dtos;

// import lombok.Builder;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @Builder
// @NoArgsConstructor
// public class AuthResponse {
    
// private final String message = "Success";
// }
public class AuthResponse {

    private final String message = "Success";

    // No-args constructor
    public AuthResponse() {
        // message is already initialized
    }

    // Getter
    public String getMessage() {
        return message;
    }

    // toString
    @Override
    public String toString() {
        return "AuthResponse{" +
                "message='" + message + '\'' +
                '}';
    }

    // equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AuthResponse that = (AuthResponse) obj;
        return message.equals(that.message);
    }

    // hashCode
    @Override
    public int hashCode() {
        return message.hashCode();
    }

    // Optional: If you still want builder functionality
    public static class AuthResponseBuilder {
        public AuthResponse build() {
            return new AuthResponse();
        }
    }

    public static AuthResponseBuilder builder() {
        return new AuthResponseBuilder();
    }
}
