/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.service.impl;

import com.av.pojo.Cauhoidiendang;
import com.av.pojo.Traloidiendan;
import com.av.repository.CauHoiRepository;
import com.av.service.CauHoiService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class CauHoiServiceImpl implements CauHoiService{
    @Autowired
    private CauHoiRepository loRepository;


    @Override
    public Object getCauHoi(Map<String, String> params) {
        return loRepository.getCauHoi(params);
    }

    @Override
    public boolean addOrUpdateTraloi(Traloidiendan p) {
       return loRepository.addOrUpdateTraloi(p);
    }

    @Override
    public List<Object> getCauHoiDienDan() {
        return loRepository.getCauHoiDienDan();
    }
    @Override
    public List<Object> getTraloi(Map<String, String> params) {
        return loRepository.getTraLoi(params);
    }

    @Override
    public boolean addOrUpdateCauHoi(Cauhoidiendang p) {
        return loRepository.addOrUpdateCauHoi(p);
    }

}
