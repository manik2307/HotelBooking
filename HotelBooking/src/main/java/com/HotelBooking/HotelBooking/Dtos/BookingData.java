package com.HotelBooking.HotelBooking.Dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class BookingData {
  

    @NotNull(message = "Number of rooms is required.")
    @Min(value = 1, message = "Number of rooms must be at least 1.")
    private Integer numberOfRooms;

    @NotNull(message = "Start date is required.")
    private LocalDate startDate;

    @NotNull(message = "End date is required.")
    private LocalDate endDate;

    // @AssertTrue(message = "Start date must be today or later.")
    // private boolean isStartDateValid() {
    //     return !startDate.isBefore(LocalDate.now());
    // }

    // @AssertTrue(message = "End date must be after start date.")
    // private boolean isEndDateValid() {
    //     return endDate.isAfter(startDate);
    // }
}
