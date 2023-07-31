/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.service.impl;

import com.av.pojo.Cauhoidiendang;
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
    public List<Cauhoidiendang> getCauhoidiendangs() {
        return loRepository.getCauhoidiendangs();
    }

    @Override
    public Cauhoidiendang getCauHoi(Map<String, String> params) {
        return loRepository.getCauHoi(params);
    }
}
