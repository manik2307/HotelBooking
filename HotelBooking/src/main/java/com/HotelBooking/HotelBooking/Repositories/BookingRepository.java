package com.HotelBooking.HotelBooking.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HotelBooking.HotelBooking.Entities.Booking;
import com.HotelBooking.HotelBooking.Entities.User;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findByCustomer(User customer);
}
