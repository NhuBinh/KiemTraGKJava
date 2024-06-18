package com.hutech.NguyenNgocNhuBinh_7317.enity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nhanViens")
public class NhanVien {
    @Id
    @Column(length = 3, nullable = false)
    private String maNV; // Employee ID

    @Column(length = 100, nullable = false)
    private String tenNV; // Employee Name

    @Column(length = 3)
    private String phai; // Gender

    @Column(length = 200)
    private String noiSinh; // Place of Birth

    @Column(length = 2)
    private String maPhong; // Department ID

    private Integer luong; // Salary

    @ManyToOne
    @JoinColumn(name = "maPhong", insertable = false, updatable = false)
    private PhongBan phongBan; // Department
}
