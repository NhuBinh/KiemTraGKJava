package com.hutech.NguyenNgocNhuBinh_7317.repository;

import com.hutech.NguyenNgocNhuBinh_7317.enity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
    Page<NhanVien> findAll(Pageable pageable);
}
