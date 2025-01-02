package com.HotelBooking.HotelBooking.Dtos;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class AuthResponse {
    
private final String message = "Success";
}
