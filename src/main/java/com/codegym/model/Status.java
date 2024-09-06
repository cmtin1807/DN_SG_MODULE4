package com.codegym.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Booked, Cancelled, Completed, Available, Unavailable, etc.

    @OneToMany(mappedBy = "status")
    private Set<Booking> bookings;

    @OneToMany(mappedBy = "status")
    private Set<Property> properties;

    // Constructors, getters and setters
}
