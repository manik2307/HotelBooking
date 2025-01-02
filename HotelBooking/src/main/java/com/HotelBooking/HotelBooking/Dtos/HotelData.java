package com.HotelBooking.HotelBooking.Dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
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

    
}
