package com.hutech.NguyenNgocNhuBinh_7317.enity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "phongBan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhongBan {
    @Id
    @Column(length = 2, nullable = false)
    private String maPhong; // Department ID

    @Column(length = 30, nullable = false)
    private String tenPhong; // Department Name

    @OneToMany(mappedBy = "phongBan")
    private Set<NhanVien> nhanViens; // Employees in the department
}
