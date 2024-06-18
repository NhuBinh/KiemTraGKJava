package com.hutech.NguyenNgocNhuBinh_7317.controller;

import com.hutech.NguyenNgocNhuBinh_7317.enity.NhanVien;
import com.hutech.NguyenNgocNhuBinh_7317.service.NhanVienService;
import com.hutech.NguyenNgocNhuBinh_7317.service.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/nhanviens")
public class NhanvienController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private PhongBanService phongBanService;

    @GetMapping
    public String showEmployeeList(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, Model model) {
        Page<NhanVien> nhanVienPage = nhanVienService.getNhanViens(page, size);
        model.addAttribute("nhanViens", nhanVienPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", nhanVienPage.getTotalPages());
        return "nhanviens/nhanvien-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("nhanVien", new NhanVien());
        model.addAttribute("phongBan", phongBanService.getAllPhongBan());
        return "nhanviens/add-nhanvien";
    }

    @PostMapping("/add")
    public String addEmployee(@Valid NhanVien nhanVien, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("phongBans", phongBanService.getAllPhongBan()); // Re-provide departments list to model if there's an error
            return "nhanviens/add-nhanvien";
        }
        nhanVienService.addNhanVien(nhanVien);
        return "redirect:/nhanviens";
    }

    @GetMapping("/edit/{maNV}")
    public String showEditForm(@PathVariable String maNV, Model model) {
        NhanVien nhanVien = nhanVienService.getNhanVienById(maNV)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee ID: " + maNV));
        model.addAttribute("nhanVien", nhanVien);
        model.addAttribute("phongBans", phongBanService.getAllPhongBan());
        return "nhanviens/update-nhanvien";
    }

    @PostMapping("/update/{maNV}")
    public String updateEmployee(@PathVariable String maNV, @Valid NhanVien nhanVien, BindingResult result) {
        if (result.hasErrors()) {
            nhanVien.setMaNV(maNV); // Set ID to ensure correct employee is updated
            return "nhanviens/update-nhanvien";
        }
        nhanVienService.updateNhanVien(nhanVien);
        return "redirect:/nhanviens";
    }

    @GetMapping("/delete/{maNV}")
    public String deleteEmployee(@PathVariable String maNV) {
        nhanVienService.deleteNhanVienById(maNV);
        return "redirect:/nhanviens";
    }
}
