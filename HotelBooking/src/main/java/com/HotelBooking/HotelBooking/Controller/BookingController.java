package com.HotelBooking.HotelBooking.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HotelBooking.HotelBooking.Dtos.AuthResponse;
import com.HotelBooking.HotelBooking.Dtos.BookingData;
import com.HotelBooking.HotelBooking.Dtos.BookingResponse;
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

    //For booking of the room in hotel(open for all type user)
    @PostMapping("/hotels/{hotelId}/book")
    public ResponseEntity<BookingResponse> bookRoom(@PathVariable("hotelId") Long hotelId, @Valid @RequestBody BookingData bookingData) {
        Long userId = bookingService.getAuthenticatedUserId();
        BookingResponse book=bookingService.BookRoom(hotelId,userId,bookingData);
       return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }
     //get request for the hotels to return all the hotels details
    //this endpoint is public and open to all 
    @GetMapping("/hotels")
    public ResponseEntity<List<Hotel>> getAllHotels()
    {
         return ResponseEntity.ok(hotelService.getAllHotels()); 
    }
    

    @DeleteMapping("/{bookingId}/cancel")
    public ResponseEntity<AuthResponse> cancelBooking(@PathVariable("bookingId") Long bookingId) {
        Long userId = bookingService.getAuthenticatedUserId();
        return ResponseEntity.ok(bookingService.CancelBooking(bookingId,userId,LocalDate.now()));
    }

    @GetMapping("/users")
    public ResponseEntity<List<BookingResponse>> getUserBookings() {
    Long userId = bookingService.getAuthenticatedUserId(); 
    List<BookingResponse> book=bookingService.getUserBookings(userId);
    return ResponseEntity.ok(book);
    }


    @PutMapping("/{bookingId}/check-in")
    public ResponseEntity<AuthResponse> checkIn(@PathVariable("bookingId") Long Bookingid) {
        Long userId = bookingService.getAuthenticatedUserId();
       return ResponseEntity.ok(bookingService.CheckIn(Bookingid,userId));
    }

    @PutMapping("/{BookingId}/check-out")
    public ResponseEntity<String> checkOut(@PathVariable("BookingId") Long BookingId) {
        Long userId = bookingService.getAuthenticatedUserId();
     return ResponseEntity.ok(bookingService.CheckOut(BookingId,userId));
    }
}
