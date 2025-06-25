// package com.HotelBooking.HotelBooking.Dtos;
//     import lombok.AllArgsConstructor;
// import lombok.Data;

// @Data
// @AllArgsConstructor
// public class BookingResponse {
//     private Long bookingId;
//     private Long hotelId;
// }
package com.HotelBooking.HotelBooking.Dtos;

public class BookingResponse {
    private Long bookingId;
    private Long hotelId;

    // All-args constructor
    public BookingResponse(Long bookingId, Long hotelId) {
        this.bookingId = bookingId;
        this.hotelId = hotelId;
    }

    // Getters
    public Long getBookingId() {
        return bookingId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    // Setters
    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    // Optional: toString
    @Override
    public String toString() {
        return "BookingResponse{" +
                "bookingId=" + bookingId +
                ", hotelId=" + hotelId +
                '}';
    }

    // Optional: equals and hashCode if needed
}


