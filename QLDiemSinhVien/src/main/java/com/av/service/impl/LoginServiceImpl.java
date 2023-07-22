/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.service.impl;

import com.av.pojo.Loaitaikhoan;
import com.av.repository.LoginRepository;
import com.av.service.LoginService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FPTSHOP
 */
@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private LoginRepository loRepository;

    @Override
    public List<Loaitaikhoan> getLoaitaikhoans() {
        return loRepository.getLoaitaikhoans();
    }
    
}
