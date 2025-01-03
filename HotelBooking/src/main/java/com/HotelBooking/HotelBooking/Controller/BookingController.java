package com.HotelBooking.HotelBooking.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HotelBooking.HotelBooking.Dtos.AuthResponse;
import com.HotelBooking.HotelBooking.Dtos.BookingData;
import com.HotelBooking.HotelBooking.Entities.Booking;
import com.HotelBooking.HotelBooking.Entities.Hotel;
import com.HotelBooking.HotelBooking.Services.BookingService;
import com.HotelBooking.HotelBooking.Services.HotelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private HotelService hotelService;
//this is an public endpoint and 
//fro jwt i ahve to implement the user and delte the user from the booking data
    @PostMapping("/hotels/{hotelId}/book")
    public ResponseEntity<Booking> bookRoom(@PathVariable Long hotelId, @Valid @RequestBody BookingData bookingData) {
        return ResponseEntity.ok(bookingService.BookRoom(hotelId,bookingData));
    }
     //get request for the hotels to return all the hotels details
    //this endpoint is public and open to all 
    @GetMapping("/hotels")
    public ResponseEntity<List<Hotel>> getAllHotels()
    {
         return ResponseEntity.ok(hotelService.getAllHotels()); 
    }
//can be only accessed by manager or the user
//in jwt we will remove the user id parameter in the path and take it from security context
    @DeleteMapping("/{bookingId}/cancel/{userId}")
    public ResponseEntity<AuthResponse> cancelBooking(@PathVariable Long bookingId,@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(bookingService.CancelBooking(bookingId,userId,LocalDate.now()));
    }
//this open for alll the user type but need authentication first
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Booking>> getUserBookings(@PathVariable Long userId) {
    return ResponseEntity.ok(bookingService.getUserBookings(userId));
    }
//this endpoint is open to the all the roles 
//in jwt we will use the user id from the spring context
    @PostMapping("/{bookingId}/check-in/{userId}")
    public ResponseEntity<Booking> checkIn(@PathVariable("bookingId") Long Bookingid,@PathVariable("userId") Long UserId) {
       return ResponseEntity.ok(bookingService.CheckIn(Bookingid,UserId));
    }

    @PostMapping("/{BookingId}/check-out/{userId}")
    public ResponseEntity<String> checkOut(@PathVariable("BookingId") Long BookingId,@PathVariable("userId") Long userId) {
     return ResponseEntity.ok(bookingService.CheckOut(BookingId,userId));
    }
}
