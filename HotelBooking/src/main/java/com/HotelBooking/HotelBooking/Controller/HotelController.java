package com.HotelBooking.HotelBooking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    //this endpoint is only for admin 
    @PostMapping
    public ResponseEntity<Hotel> CreateHotel(@Valid @RequestBody HotelData hoteldata)
    {
       return ResponseEntity.ok(hotelService.CreateHotel(hoteldata));
    }

    //get request for the hotels to return all the hotels details
    //this endpoint is public and open to all 
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels()
    {
         return ResponseEntity.ok(hotelService.getAllHotels()); 
    }

    //put request for the hotel detail update and here id is of hotel
    //this end point open for HotelManager,Admin
    @PutMapping("/{hotelId}")
    public ResponseEntity<Hotel> UpdateHotel(@Valid @RequestBody HotelData hotelData,@PathVariable("hotelId")  Long id)
    {
       return ResponseEntity.ok(hotelService.UpdateHotel(hotelData,id));
    }

    //delete request for the hotels by passing the hotel id in the url ex: /hotels/2 (here 2 is id)
    //this end point is only for admin
    @DeleteMapping("/{hotelId}")
    public ResponseEntity<AuthResponse> DeleteHotel(@PathVariable("hotelId")  Long id)
    {
        return ResponseEntity.ok(hotelService.DeleteHotel(id));
    }
    //in future we can build endpoint to see all the bookings of the hotel
    //ex:GET /hotels/{hotelId}/bookings by making this request
}
