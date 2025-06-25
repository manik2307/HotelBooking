package com.HotelBooking.HotelBooking.Dtos;

public class Auth {
    private final String message = "Success";
    private String accessToken;

    // No-args constructor
    public Auth() {
    }

    // All-args constructor (excluding final field, since it's already initialized)
    public Auth(String accessToken) {
        this.accessToken = accessToken;
    }

    // Getter for message
    public String getMessage() {
        return message;
    }

    // Getter and Setter for accessToken
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    // toString
    @Override
    public String toString() {
        return "Auth{" +
                "message='" + message + '\'' +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auth)) return false;

        Auth auth = (Auth) o;

        if (!message.equals(auth.message)) return false;
        return accessToken != null ? accessToken.equals(auth.accessToken) : auth.accessToken == null;
    }

    // hashCode
    @Override
    public int hashCode() {
        int result = message.hashCode();
        result = 31 * result + (accessToken != null ? accessToken.hashCode() : 0);
        return result;
    }

    // Optional: Builder pattern manually (if you still want @Builder functionality)
    public static class AuthBuilder {
        private String accessToken;

        public AuthBuilder accessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        public Auth build() {
            return new Auth(accessToken);
        }
    }

    public static AuthBuilder builder() {
        return new AuthBuilder();
    }
}

