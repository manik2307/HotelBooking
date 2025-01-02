package com.HotelBooking.HotelBooking.Entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "bookings")
public class Booking {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private User customer;

   @Column(nullable = false)
    private Integer numberOfRooms;

    @Column(nullable = false)
    private LocalDate startDate; // Booking start date (date only)

    @Column(nullable = false)
    private LocalDate endDate; // Booking end date (date only)

    @Column
    private LocalDateTime checkInDate; // Date and time of check-in

    @Column
    private LocalDateTime checkOutDate; // Date and time of check-out

    @Column
    private Double extraCharge=100.0;
}
