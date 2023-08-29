/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.service.impl;

import com.av.pojo.Giangvien;
import com.av.repository.GiangvienRepository;
import com.av.service.GiangVienService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FPTSHOP
 */
@Service
public class GiangVienServiceImpl implements GiangVienService{
    
    @Autowired
    private GiangvienRepository giangVienRepository;
    
    @Override
    public List<Giangvien> getGiangviens() {
        return this.giangVienRepository.getGiangviens();
    }

    @Override
    public boolean addOrUpdateGiangVien(Giangvien gv) {
        return this.giangVienRepository.addOrUpdateGiangVien(gv);
    }

    @Override
    public Giangvien getGiangVienById(int idGiangVien) {
        return this.giangVienRepository.getGiangVienById(idGiangVien);
    }

    @Override
    public boolean deleteGV(int idGiangVien) {
        return this.giangVienRepository.deleteGV(idGiangVien);
    }

    @Override
    public Giangvien getGiangVienByIdTaiKhoan(int idTaiKhoan) {
        return this.giangVienRepository.getGiangVienByIdTaiKhoan(idTaiKhoan);
    }

    
    
    
}
