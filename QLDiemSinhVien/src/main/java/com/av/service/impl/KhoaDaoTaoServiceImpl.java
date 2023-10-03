/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.service.impl;

import com.av.pojo.Khoa;
import com.av.pojo.Khoadaotao;
import com.av.pojo.Nganhdaotao;
import com.av.pojo.Phonghoc;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.av.repository.KhoaDaoTaoRepository;
import com.av.service.KhoaDaoTaoService;

/**
 *
 * @author FPTSHOP
 */
@Service
public class KhoaDaoTaoServiceImpl implements KhoaDaoTaoService{
    
    @Autowired
    private KhoaDaoTaoRepository KhoaDaoTaoRepository;

    @Override
    public List<Khoa> getKhoas(Map<String, String> params) {
        return this.KhoaDaoTaoRepository.getKhoas(params);
    }

    @Override
    public List<Khoadaotao> getKhoadaotaos(Map<String, String> params) {
        return this.KhoaDaoTaoRepository.getKhoadaotaos(params);
    }

    @Override
    public List<Phonghoc> getPhonghocs(Map<String, String> params) {
        return  this.KhoaDaoTaoRepository.getPhonghocs(params);
    }

    @Override
    public List<Nganhdaotao> getNganhdaotaos(Map<String, String> params) {
        return  this.KhoaDaoTaoRepository.getNganhdaotaos(params);
    }

    
}
