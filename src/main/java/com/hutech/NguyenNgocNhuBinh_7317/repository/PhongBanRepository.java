package com.hutech.NguyenNgocNhuBinh_7317.repository;

import com.hutech.NguyenNgocNhuBinh_7317.enity.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongBanRepository extends JpaRepository<PhongBan, String> {

}
