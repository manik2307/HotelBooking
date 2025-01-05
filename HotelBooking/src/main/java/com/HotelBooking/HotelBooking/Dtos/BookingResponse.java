package com.HotelBooking.HotelBooking.Dtos;
    import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingResponse {
    private Long bookingId;
    private Long hotelId;
}


