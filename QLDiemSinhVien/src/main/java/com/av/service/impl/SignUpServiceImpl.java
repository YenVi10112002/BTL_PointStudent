/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.service.impl;

import com.av.pojo.Taikhoan;
import com.av.repository.SignUpRepository;
import com.av.service.SignUpService;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author FPTSHOP
 */
@Service
public class SignUpServiceImpl implements SignUpService{

    @Autowired
    private SignUpRepository signUpRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Override
    public boolean addAcount(Taikhoan t) {
        String pass = t.getMatKhau();
        t.setMatKhau(this.passwordEncoder.encode(pass));
        t.setChucVu(Taikhoan.SV);
        return signUpRepo.addAcount(t);
    }
    
}
