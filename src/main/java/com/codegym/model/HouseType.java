package com.codegym.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "house_type")
@Data
public class HouseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;  // Tên loại nhà (ví dụ: Villa, Căn hộ)

    @OneToMany(mappedBy = "houseType")
    private List<HomeStay> homestays;  // Liên kết với bảng homestay
}
