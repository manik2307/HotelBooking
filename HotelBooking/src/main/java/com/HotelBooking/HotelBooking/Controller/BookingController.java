package com.HotelBooking.HotelBooking.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HotelBooking.HotelBooking.Dtos.BookingData;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    //   @PostMapping("/{hotelId}/book")
    // public ResponseEntity<?> bookRoom(@PathVariable Long hotelId, @RequestBody BookingData bookingData) {
    //     // Implementation
    // }

    // @DeleteMapping("/{bookingId}")
    // public ResponseEntity<?> cancelBooking(@PathVariable Long bookingId) {
    //     // Implementation
    // }

    // @GetMapping("/users/{userId}")
    // public ResponseEntity<List<BookingData>> getUserBookings(@PathVariable Long userId) {
    //     // Implementation
    // }

    // @PostMapping("/{id}/check-in")
    // public ResponseEntity<?> checkIn(@PathVariable Long id) {
    //     // Implementation
    // }

    // @PostMapping("/{id}/check-out")
    // public ResponseEntity<?> checkOut(@PathVariable Long id) {
    //     // Implementation
    // }
}
