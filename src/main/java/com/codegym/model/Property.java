package com.codegym.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;
@Data
@Entity
@Table(name = "properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "property_type_id")
    private PropertyType propertyType; // Apartment, House, etc.

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType; // Entire place, Private room, Shared room

    private String address;

    private int bedrooms;

    private int bathrooms;

    @Lob
    private String description;

    private double pricePerNight;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status; // Sử dụng bảng Status để quản lý trạng thái

    @OneToMany(mappedBy = "property")
    private Set<Booking> bookings;

    @OneToMany(mappedBy = "property")
    private Set<Review> reviews;

    @OneToMany(mappedBy = "property")
    private Set<PropertyImage> images;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // Constructors, getters and setters
}

