package com.HotelBooking.HotelBooking.Services;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelBooking.HotelBooking.Dtos.AuthResponse;
import com.HotelBooking.HotelBooking.Dtos.BookingData;
import com.HotelBooking.HotelBooking.Entities.Booking;
import com.HotelBooking.HotelBooking.Entities.Hotel;
import com.HotelBooking.HotelBooking.Entities.User;
import com.HotelBooking.HotelBooking.Repositories.BookingRepository;
import com.HotelBooking.HotelBooking.Repositories.HotelRepository;
import com.HotelBooking.HotelBooking.Repositories.UserRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private UserRepository userRepository;

    // Helper method for user validation
    private User validateUser(Long userId) {
        return userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
    }

    // Helper method to check if booking belongs to the user
    private Booking validateBookingOwnership(Long bookingId, Long userId) {
        Booking booking = bookingRepository.findById(bookingId)
            .orElseThrow(() -> new IllegalArgumentException("Booking not found with ID: " + bookingId));

        if (!booking.getCustomer().getId().equals(userId)) {
            throw new IllegalArgumentException("This booking does not belong to the specified user.");
        }
        return booking;
    }

    // Helper method for calculating extra charges
    private double calculateExtraCharges(Booking booking, LocalDateTime currentTime) {
        long hoursStayed = Duration.between(booking.getEndDate().atTime(23, 59, 59), currentTime).toHours();
        double extraChargePerHour = booking.getExtraCharge() != null ? booking.getExtraCharge() : 100.0;
        return hoursStayed * extraChargePerHour;
    }

    // Method to book the room
    public Booking BookRoom(Long hotelId, BookingData bookingData) {
        // Step 1: Validate Hotel
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new IllegalArgumentException("Hotel not found with ID: " + hotelId));

        // Step 2: Validate User
        User user = validateUser(bookingData.getUserId());

        // Step 3: Check Room Availability
        if (hotel.getAvailableRooms() < bookingData.getNumberOfRooms()) {
            throw new IllegalStateException("Not enough rooms available.");
        }

        // Step 4: Update Room Availability
        hotel.setAvailableRooms(hotel.getAvailableRooms() - bookingData.getNumberOfRooms());
        hotelRepository.save(hotel);

        // Step 5: Create Booking Entity
        Booking booking = new Booking();
        booking.setHotel(hotel);
        booking.setCustomer(user);
        booking.setNumberOfRooms(bookingData.getNumberOfRooms());
        booking.setStartDate(bookingData.getStartDate());
        booking.setEndDate(bookingData.getEndDate());

        // Step 6: Save and Return Booking
        return bookingRepository.save(booking);
    }

    // Method to cancel the booking
    public AuthResponse CancelBooking(Long bookingId, Long userId, LocalDate cancellationDate) {
        Booking booking = validateBookingOwnership(bookingId, userId);

        // Check if the cancellation date is before the start date
        if (!cancellationDate.isBefore(booking.getStartDate())) {
            throw new IllegalStateException("Cancellation is only allowed before the start date of the booking.");
        }

        // Process cancellation (e.g., remove booking, update room availability)
        Hotel hotel = booking.getHotel();
        hotel.setAvailableRooms(hotel.getAvailableRooms() + 1);
        hotelRepository.save(hotel);
        bookingRepository.delete(booking);

        return AuthResponse.builder().build();
    }

    // Method to get user bookings
    public List<Booking> getUserBookings(Long userId) {
        User user = validateUser(userId);
        return bookingRepository.findByCustomer(user);
    }

    // Method to check-in
    public Booking CheckIn(Long bookingId, Long userId) {
        Booking booking = validateBookingOwnership(bookingId, userId);

        // Step 3: Check if the current time is within the booking period (between startDate and endDate)
        LocalDateTime currentTime = LocalDateTime.now();
        if (currentTime.isBefore(booking.getStartDate().atStartOfDay()) || currentTime.isAfter(booking.getEndDate().atTime(23, 59, 59))) {
            throw new IllegalArgumentException("Check-in is not allowed outside the booking period.");
        }

        // Step 4: Update the checkInDate attribute of the booking
        booking.setCheckInDate(currentTime);
        bookingRepository.save(booking);  // Save the updated booking
        return booking;
    }

    // Method to check-out
    public String CheckOut(Long bookingId, Long userId) {
        Booking booking = validateBookingOwnership(bookingId, userId);

        // Check if the user has already checked in
        if (booking.getCheckInDate() == null) {
            throw new IllegalArgumentException("User has not checked in yet.");
        }

        // Step 3: Check if the current time is after the booking end date and calculate extra charges if necessary
        LocalDateTime currentTime = LocalDateTime.now();
        if (currentTime.isAfter(booking.getEndDate().atTime(23, 59, 59))) {
            // Calculate extra charges
            double extraCharge = calculateExtraCharges(booking, currentTime);

            // Update extra charges in the booking
            booking.setExtraCharge(extraCharge);
            booking.setCheckOutDate(currentTime); // Set the check-out date and time
            bookingRepository.save(booking);  // Save the updated booking

            return "You have overstayed by " + extraCharge + " hours. Extra charges of " + extraCharge + " have been applied. You have successfully checked out. Please visit again!";
        }

        // If the current time is within the booking period, proceed with checkout without extra charges
        booking.setCheckOutDate(currentTime); // Set the check-out date and time
        bookingRepository.save(booking);  // Save the updated booking

        return "You have successfully checked out. Please visit again!";
    }
}
