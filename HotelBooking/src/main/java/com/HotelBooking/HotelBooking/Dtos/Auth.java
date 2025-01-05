package com.HotelBooking.HotelBooking.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Auth{
  private final String message = "Success";
  private String accessToken;
}

