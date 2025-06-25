// package com.HotelBooking.HotelBooking.Dtos;

// import jakarta.validation.constraints.Min;
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.Size;
// import lombok.Data;
// @Data
// public class HotelData {
    
//     @NotBlank(message = "Hotel name is required.")
//     @Size(max = 255, message = "Hotel name must not exceed 255 characters.")
//     private String name;

//     @NotBlank(message = "Location is required.")
//     @Size(max = 255, message = "Location must not exceed 255 characters.")
//     private String location;

//     @Size(max = 500, message = "Description must not exceed 500 characters.")
//     private String description;

//     @NotNull(message = "Available rooms must be specified.")
//     @Min(value = 1, message = "Available rooms must be at least 1.")
//     private Integer availableRooms;

    
// }
package com.HotelBooking.HotelBooking.Dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class HotelData {

    @NotBlank(message = "Hotel name is required.")
    @Size(max = 255, message = "Hotel name must not exceed 255 characters.")
    private String name;

    @NotBlank(message = "Location is required.")
    @Size(max = 255, message = "Location must not exceed 255 characters.")
    private String location;

    @Size(max = 500, message = "Description must not exceed 500 characters.")
    private String description;

    @NotNull(message = "Available rooms must be specified.")
    @Min(value = 1, message = "Available rooms must be at least 1.")
    private Integer availableRooms;

    // Getters
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public Integer getAvailableRooms() {
        return availableRooms;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvailableRooms(Integer availableRooms) {
        this.availableRooms = availableRooms;
    }

    // Optional: toString()
    @Override
    public String toString() {
        return "HotelData{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", availableRooms=" + availableRooms +
                '}';
    }

    // Optional: equals() and hashCode() if needed for comparison or collections
}
