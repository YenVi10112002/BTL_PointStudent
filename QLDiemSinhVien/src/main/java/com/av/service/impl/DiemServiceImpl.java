/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.service.impl;

import com.av.repository.DiemRepository;
import com.av.service.DiemService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class DiemServiceImpl implements DiemService {

    @Autowired
    private DiemRepository diemRepository;

    @Override
    public double getDiemTrungBinh(int sinhvienId){
        return diemRepository.getDiemTrungBinh(sinhvienId);
    }
    @Override
    public double getDiemTrungBinhHe(int sinhvienId){
        return diemRepository.getDiemTrungBinhHe(sinhvienId);
    }

    @Override
    public List<Object> getListDiem(int sinhvienId) {
        return diemRepository.getListDiem(sinhvienId);
    }

    @Override
    public List<Object> getListDiemTrungBinh(int sinhvienId) {
        return diemRepository.getListDiemTrungBinh(sinhvienId);
    }
    @Override
    public List<Object> getListDiemTrungBinh2(Map<String, String> params) {
        return diemRepository.getListDiemTrungBinh2(params);
    }
    @Override
    public double getDiemTrungBinh2(Map<String, String> params) {
        return diemRepository.getDiemTrungBinh2(params);
    }
    @Override
    public double getDiemTrungBinhHe4(Map<String, String> params) {
        return diemRepository.getDiemTrungBinhHe4(params);
    }
    @Override
    public List<Object> getListDiem2(Map<String, String> params) {
        return diemRepository.getListDiem2(params);
    }
}
