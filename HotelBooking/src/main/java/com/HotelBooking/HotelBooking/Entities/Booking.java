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
    private Double extraCharge = 100.0;

    // No-argument constructor
    public Booking() {
        this.extraCharge = 100.0; // default value
    }

    // All-argument constructor
    public Booking(Long id, Hotel hotel, User customer, Integer numberOfRooms, LocalDate startDate, LocalDate endDate,
                   LocalDateTime checkInDate, LocalDateTime checkOutDate, Double extraCharge) {
        this.id = id;
        this.hotel = hotel;
        this.customer = customer;
        this.numberOfRooms = numberOfRooms;
        this.startDate = startDate;
        this.endDate = endDate;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.extraCharge = (extraCharge != null) ? extraCharge : 100.0;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

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

    public LocalDateTime getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDateTime checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDateTime getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDateTime checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Double getExtraCharge() {
        return extraCharge;
    }

    public void setExtraCharge(Double extraCharge) {
        this.extraCharge = extraCharge;
    }
}
