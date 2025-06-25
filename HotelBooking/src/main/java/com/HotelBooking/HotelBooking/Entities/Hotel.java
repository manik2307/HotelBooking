// package com.HotelBooking.HotelBooking.Entities;

// import java.util.ArrayList;
// import java.util.List;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.Table;
// import lombok.Data;
// @Data
// @Entity
// @Table(name = "hotels")
// public class Hotel {
    
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private String name;

//     @Column(nullable = false)
//     private String location;

//     @Column(length = 500)
//     private String description;

//     @Column(nullable = false)
//     private Integer availableRooms;

//     @OneToMany(mappedBy = "hotel")
//     List<Booking> bookings=new ArrayList<>();
// }
package com.HotelBooking.HotelBooking.Entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotels")
public class Hotel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private Integer availableRooms;

    @OneToMany(mappedBy = "hotel")
    private List<Booking> bookings = new ArrayList<>();

    // No-argument constructor
    public Hotel() {
    }

    // All-argument constructor
    public Hotel(Long id, String name, String location, String description, Integer availableRooms, List<Booking> bookings) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
        this.availableRooms = availableRooms;
        this.bookings = bookings != null ? bookings : new ArrayList<>();
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(Integer availableRooms) {
        this.availableRooms = availableRooms;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
