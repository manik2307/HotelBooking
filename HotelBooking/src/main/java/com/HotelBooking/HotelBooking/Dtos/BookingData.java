 package com.HotelBooking.HotelBooking.Dtos;

// import java.time.LocalDate;

// import jakarta.validation.constraints.AssertTrue;
// import jakarta.validation.constraints.Min;
// import jakarta.validation.constraints.NotNull;
// import lombok.Data;
// @Data
// public class BookingData {
  

//     @NotNull(message = "Number of rooms is required.")
//     @Min(value = 1, message = "Number of rooms must be at least 1.")
//     private Integer numberOfRooms;

//     @NotNull(message = "Start date is required.")
//     private LocalDate startDate;

//     @NotNull(message = "End date is required.")
//     private LocalDate endDate;

//     // @AssertTrue(message = "Start date must be today or later.")
//     // private boolean isStartDateValid() {
//     //     return !startDate.isBefore(LocalDate.now());
//     // }

//     // @AssertTrue(message = "End date must be after start date.")
//     // private boolean isEndDateValid() {
//     //     return endDate.isAfter(startDate);
//     // }
// }


import java.time.LocalDate;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class BookingData {

    @NotNull(message = "Number of rooms is required.")
    @Min(value = 1, message = "Number of rooms must be at least 1.")
    private Integer numberOfRooms;

    @NotNull(message = "Start date is required.")
    private LocalDate startDate;

    @NotNull(message = "End date is required.")
    private LocalDate endDate;

    // Getters and Setters
    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    // Optional: toString
    @Override
    public String toString() {
        return "BookingData{" +
                "numberOfRooms=" + numberOfRooms +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    // Optional: equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookingData)) return false;

        BookingData that = (BookingData) o;

        if (numberOfRooms != null ? !numberOfRooms.equals(that.numberOfRooms) : that.numberOfRooms != null)
            return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null)
            return false;
        return endDate != null ? endDate.equals(that.endDate) : that.endDate == null;
    }

    @Override
    public int hashCode() {
        int result = numberOfRooms != null ? numberOfRooms.hashCode() : 0;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }
}
