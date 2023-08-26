/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.service.impl;

import com.av.pojo.Monhoc;
import com.av.repository.MonHocRepository;
import com.av.service.MonHocService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FPTSHOP
 */
@Service
public class MonHocServiceImpl  implements MonHocService{
    
    @Autowired
    private MonHocRepository mhRepository;

    @Override
    public List<Monhoc> getMonHocs() {
        return this.mhRepository.getMonHocs();
    }

    @Override
    public boolean addOrUpdateMonHoc(Monhoc mh) {
        return  this.mhRepository.addOrUpdateMonHoc(mh);
    }

    @Override
    public Monhoc getMonHocById(int id) {
        return this.mhRepository.getMonHocById(id);
    }

    @Override
    public boolean deleteMonHoc(int id) {
        return this.mhRepository.deleteMonHoc(id);
    }
    
}
