/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.service.impl;

import com.av.pojo.Diem;
import com.av.pojo.Sinhvien;
import com.av.pojo.Taikhoan;
import com.av.pojo.Traloidiendan;
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
public class SinhVienServiceImpl implements SinhVienService{
    @Autowired
    private SinhVienRepository tongRepository;
    @Override
    public Sinhvien getSinhvien(int idTaiKhoan){
        
        return tongRepository.getSinhVien(idTaiKhoan);
        
    }
    
    @Override
    public int getHocKy(){
    return tongRepository.getHocKy();
    }

    @Override
    public Taikhoan getTaiKhoan(int idTaiKhoan) {
        return tongRepository.getTaiKhoan(idTaiKhoan);
    }
    
    
    
    
}
