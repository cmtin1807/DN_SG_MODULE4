package com.codegym.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "house_status")
@Data
public class HomeStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "house_id", nullable = false)
    private HomeStay homeStatus;  // Nhà đang được theo dõi trạng thái

    @Column(name = "status", nullable = false)
    private String status;  // Trạng thái (có sẵn, đã thuê, bảo trì, v.v.)

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;  // Thời điểm bắt đầu trạng thái

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;  // Thời điểm kết thúc trạng thái


}
