package com.HotelBooking.HotelBooking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.HotelBooking.HotelBooking.Dtos.AuthResponse;
import com.HotelBooking.HotelBooking.Dtos.HotelData;
import com.HotelBooking.HotelBooking.Entities.Hotel;
import com.HotelBooking.HotelBooking.Services.HotelService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    
    @Autowired
    private HotelService hotelService;

    //post for creating an hotel
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Hotel> CreateHotel(@Valid @RequestBody HotelData hoteldata)
    {
       Hotel hotel=hotelService.CreateHotel(hoteldata);
       return ResponseEntity.status(HttpStatus.CREATED).body(hotel);
    }

    //put request for the hotel detail update and here id is of hotel
    @PreAuthorize("hasRole('ADMIN') or hasRole('HOTEL_MANAGER')")
    @PutMapping("/{hotelId}")
    public ResponseEntity<Hotel> UpdateHotel(@Valid @RequestBody HotelData hotelData,@PathVariable("hotelId")  Long id)
    {
       return ResponseEntity.ok(hotelService.UpdateHotel(hotelData,id));
    }

    //delete request for the hotels by passing the hotel id in the url ex: /hotels/2 (here 2 is id)
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{hotelId}")
    public ResponseEntity<AuthResponse> DeleteHotel(@PathVariable("hotelId")  Long id)
    {
       hotelService.DeleteHotel(id);
       return ResponseEntity.noContent().build();
    }
    
}
