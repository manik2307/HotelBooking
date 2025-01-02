package com.HotelBooking.HotelBooking.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HotelBooking.HotelBooking.Entities.Hotel;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel,Long> {

    Optional<Hotel> findByLocation(String location);
    
}
