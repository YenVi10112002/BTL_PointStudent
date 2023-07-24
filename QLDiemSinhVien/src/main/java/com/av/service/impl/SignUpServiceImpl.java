/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.service.impl;

import com.av.pojo.Taikhoan;
import com.av.repository.SignUpRepository;
import com.av.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FPTSHOP
 */
@Service
public class SignUpServiceImpl implements SignUpService{

    @Autowired
    private SignUpRepository signUpRepo;
    @Override
    public boolean addOrUpdateAcount(Taikhoan t) {
        return signUpRepo.addOrUpdateAcount(t);
    }
    
}
