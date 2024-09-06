package com.codegym.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "property_type")
@Data
public class PropertyType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
