package com.hutech.NguyenNgocNhuBinh_7317.service;

import com.hutech.NguyenNgocNhuBinh_7317.enity.PhongBan;
import com.hutech.NguyenNgocNhuBinh_7317.repository.PhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class PhongBanService {
    @Autowired
    private PhongBanRepository phongBanRepository;

    public List<PhongBan> getAllPhongBan() {
        return phongBanRepository.findAll();
    }
}
