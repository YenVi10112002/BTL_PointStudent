/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.service.impl;

import com.av.pojo.Sinhvien;
import com.av.pojo.Taikhoan;
import com.av.repository.TaiKhoanRepository;
import com.av.service.TaiKhoanService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {

    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private TaiKhoanRepository taikhoanRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public boolean updateImg(Taikhoan s) {
        if (!s.getFile().isEmpty()) {
            try {
                Map r = this.cloudinary.uploader().upload(s.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                s.setImage(r.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(TaiKhoanService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.taikhoanRepository.updateImg(s);
    }
    @Override
    public Taikhoan getTaiKhoan(int idTaiKhoan) {
        return taikhoanRepository.getTaiKhoan(idTaiKhoan);
    }
    
    @Override
    public boolean addAcount(Taikhoan t) {
        String pass = t.getMatKhau();
        t.setMatKhau(this.passwordEncoder.encode(pass));
        t.setChucVu(Taikhoan.SV);
        
        return taikhoanRepository.addAcount(t);
    }
    @Override
    public boolean addAcountGV(Taikhoan t) {
        String pass = t.getMatKhau();
        t.setMatKhau(this.passwordEncoder.encode(pass));
        t.setChucVu(Taikhoan.GV);
        return taikhoanRepository.addAcountGV(t);
    }

    @Override
    public List<Taikhoan> getTaiKhoan() {
        return this.taikhoanRepository.getTaiKhoan();
    }

}
