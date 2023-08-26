/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.service.impl;

import com.av.pojo.Diem;
import com.av.pojo.Giangvien;
import com.av.repository.DiemRepository;
import com.av.service.DiemService;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
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
    public boolean addDiem(Diem d) {
        return diemRepository.addDiem(d);
    }
    

}
