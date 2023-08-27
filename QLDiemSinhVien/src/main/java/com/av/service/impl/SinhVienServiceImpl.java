/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.service.impl;

import com.av.pojo.Lophoc;
import com.av.pojo.Sinhvien;
import com.av.pojo.Taikhoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.av.repository.SinhVienRepository;
import com.av.service.SinhVienService;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
@Service
public class SinhVienServiceImpl implements SinhVienService {

    @Autowired
    private SinhVienRepository sinhvienRepository;

    @Override
    public Sinhvien getSinhvien(int idTaiKhoan) {

        return sinhvienRepository.getSinhVien(idTaiKhoan);

    }

    @Override
    public List<Sinhvien> getSinhviens(Map<String, String> params) {
        return sinhvienRepository.getSinhviens(params);
    }
    @Override
    public List<Lophoc> getLopHocs() {
        return sinhvienRepository.getLopHocs();
    }

    @Override
    public boolean addOrUpdateSinhVien(Sinhvien sv) {
        return sinhvienRepository.addOrUpdateSinhVien(sv);
    }

    @Override
    public Sinhvien getSinhVienById(int idSinhVien) {
        return sinhvienRepository.getSinhVienById(idSinhVien);
    }

    @Override
    public boolean deleteSinhVien(int idSinhVien) {
        return sinhvienRepository.deleteSinhVien(idSinhVien);
    }
}
