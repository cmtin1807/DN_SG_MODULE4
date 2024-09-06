package com.codegym.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "home_image")
@Data
public class HomeImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;  // Đường dẫn hình ảnh

    @ManyToOne
    @JoinColumn(name = "homestay_id", nullable = false)
    private HomeStay homestay;  // Liên kết với bảng homestay
}
