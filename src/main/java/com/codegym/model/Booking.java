package com.codegym.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "house_id", nullable = false)
    private HomeStay homeStay;  // Căn nhà đã được đặt thuê

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;  // Ngày bắt đầu thuê

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;  // Ngày kết thúc thuê

    @Column(name = "is_cancellable", nullable = false)
    private boolean isCancellable = true;  // Cho phép hủy hay không (sẽ cập nhật khi gần đến ngày thuê)

    @PrePersist
    public void prePersist() {
        // Kiểm tra nếu ngày bắt đầu thuê gần (chỉ còn 1 ngày trước khi bắt đầu)
        if (LocalDate.now().isAfter(startDate.minusDays(1))) {
            isCancellable = false;
        }
    }


}

