/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.service.impl;

import com.av.pojo.PhieuMonHoc;
import com.av.repository.MonHocRepository;
import com.av.repository.PhieuMonHocRepository;
import com.av.service.PhieuMonHocService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FPTSHOP
 */
@Service
public class PhieuMonHocServiceImpl implements PhieuMonHocService{
    
    @Autowired
    private PhieuMonHocRepository phieuMHRepo;

    @Override
    public boolean addPhieuMH(Map<String, PhieuMonHoc> carts) {
        return this.phieuMHRepo.addPhieuMH(carts);
    }

    @Override
    public PhieuMonHoc getPhieuMonHoc() {
        return this.phieuMHRepo.getPhieuMonHoc();
    }

    @Override
    public boolean deletePhieuMH(int idMonHoc) {
        return this.phieuMHRepo.deletePhieuMH(idMonHoc);
    }
    
}
