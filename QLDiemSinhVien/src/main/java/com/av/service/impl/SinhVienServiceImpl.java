/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.service.impl;

import com.av.pojo.Sinhvien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.av.repository.SinhVienRepository;
import com.av.service.SinhVienService;

/**
 *
 * @author Admin
 */
@Service
public class SinhVienServiceImpl implements SinhVienService{
    @Autowired
    private SinhVienRepository tongRepository;
    @Override
    public Sinhvien getSinhvien(int sinhvienId){
        
        return tongRepository.getSinhVien(sinhvienId);
        
    }
    
}
