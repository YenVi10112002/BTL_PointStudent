/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.service.impl;

import com.av.pojo.Cauhoidiendang;
import com.av.pojo.Sinhvien;
import com.av.repository.CauHoiRepository;
import com.av.repository.ListSinhVienRepository;
import com.av.service.ListSinhVienService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ListSinhVienServiceImpl implements ListSinhVienService{
    @Autowired
    private ListSinhVienRepository loRepository;

    @Override
    public List<Sinhvien> getSinhviens(Map<String, String> params) {
        return loRepository.getSinhviens(params);
    }
}
