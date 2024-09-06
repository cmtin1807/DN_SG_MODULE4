package com.codegym.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "homestay")
@Data
public class HomeStay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;  // Tên căn nhà

    @ManyToOne
    @JoinColumn(name = "house_type_id", nullable = false)
    private HouseType houseType;  // Liên kết với bảng loại nhà

    @ManyToOne
    @JoinColumn(name = "room_type_id", nullable = false)
    private RoomType roomType;  // Liên kết với bảng loại phòng

    @Column(name = "address", nullable = false)
    private String address;  // Địa chỉ

    @Column(name = "bedrooms", nullable = false)
    private int bedrooms;  // Số lượng phòng ngủ

    @Column(name = "bathrooms", nullable = false)
    private int bathrooms;  // Số lượng phòng tắm

    @Column(name = "description")
    private String description;  // Mô tả chung

    @Column(name = "price_per_night", nullable = false)
    private double pricePerNight;  // Giá tiền theo đêm

    @OneToMany(mappedBy = "homestay", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HomeImage> images;  // Liên kết với bảng hình ảnh
}
