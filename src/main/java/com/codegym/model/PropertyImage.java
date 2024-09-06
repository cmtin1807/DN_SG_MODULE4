package com.codegym.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "property_images")
public class PropertyImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    // Constructors, getters and setters
}

