package com.HotelBooking.HotelBooking.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.HotelBooking.HotelBooking.Dtos.AuthResponse;
import com.HotelBooking.HotelBooking.Dtos.HotelData;
import com.HotelBooking.HotelBooking.Entities.Hotel;
import com.HotelBooking.HotelBooking.Repositories.HotelRepository;


@Service
public class HotelService {
    
    @Autowired
    private HotelRepository hotelRepository;
   

 // Create a new hotel
 public Hotel CreateHotel(HotelData hoteldata) {
    // Step 1: Check if a hotel with the same address already exists in the database.
    Optional<Hotel> existingHotel = hotelRepository.findByLocation(hoteldata.getLocation());

    if (existingHotel.isPresent()) {
        // If a hotel with the same location exists, return a response indicating failure.
        throw new IllegalArgumentException("Hotel with the same address already exists.");
    }

    // Step 2: Create a new Hotel entity from the provided hotel data.
    Hotel hotel = new Hotel();
    hotel.setName(hoteldata.getName());
    hotel.setLocation(hoteldata.getLocation());
    hotel.setDescription(hoteldata.getDescription());
    hotel.setAvailableRooms(hoteldata.getAvailableRooms());

    // Step 3: Save the new hotel entity in the database.
    return hotelRepository.save(hotel);

}

// Get all hotels
public List<Hotel> getAllHotels() {
    return hotelRepository.findAll();
}

// Get hotel by ID
private Hotel getHotelById(Long hotelId) {
    // Step 1: Find the hotel by ID.
    Optional<Hotel> existingHotel = hotelRepository.findById(hotelId);

    if (!existingHotel.isPresent()) {
        // If the hotel doesn't exist, throw an exception.
        throw new IllegalArgumentException("Hotel not found with ID: " + hotelId);
    }

    // Step 2: Return the found hotel.
    return existingHotel.get();
}

// Update an existing hotel by ID
public Hotel UpdateHotel(HotelData hotelData, Long hotelId) {
    // Step 1: Get the hotel by ID using the helper method.
    Hotel hotel = getHotelById(hotelId);

    // Step 2: Update the hotel details.
    hotel.setName(hotelData.getName());
    hotel.setLocation(hotelData.getLocation());
    hotel.setDescription(hotelData.getDescription());
    hotel.setAvailableRooms(hotelData.getAvailableRooms());

    // Step 3: Save the updated hotel entity.
    return hotelRepository.save(hotel);
}

// Delete a hotel by ID
public void DeleteHotel(Long id) {
    // Step 1: Get the hotel by ID using the helper method.
    Hotel hotel = getHotelById(id);

    // Step 2: Delete the hotel.
    hotelRepository.deleteById(id);

    // Step 3: Return a success response.
    return;
}
    
}
