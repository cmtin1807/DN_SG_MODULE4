package com.codegym.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "room_type")
@Data
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;  // Tên loại phòng (ví dụ: Phòng đơn, Phòng đôi)

    @OneToMany(mappedBy = "roomType")
    private List<HomeStay> homestays;  // Liên kết với bảng homestay
}
