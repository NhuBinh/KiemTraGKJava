package com.hutech.NguyenNgocNhuBinh_7317.service;

import com.hutech.NguyenNgocNhuBinh_7317.enity.NhanVien;
import com.hutech.NguyenNgocNhuBinh_7317.repository.NhanVienRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    public Page<NhanVien> getNhanViens(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return nhanVienRepository.findAll(pageable);
    }

    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepository.findAll();
    }

    public Optional<NhanVien> getNhanVienById(String maNV) {
        return nhanVienRepository.findById(maNV);
    }

    public NhanVien addNhanVien(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    public NhanVien updateNhanVien(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    public void deleteNhanVienById(String maNV) {
        nhanVienRepository.deleteById(maNV);
    }
}
