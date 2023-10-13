/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.av.service;

import com.av.pojo.Khoa;
import com.av.pojo.Khoadaotao;
import com.av.pojo.Nganhdaotao;
import com.av.pojo.Phonghoc;
import java.util.List;
import java.util.Map;

/**
 *
 * @author FPTSHOP
 */
public interface KhoaDaoTaoService {
    List<Khoa> getKhoas(Map<String, String> params);
    List<Khoadaotao> getKhoadaotaos (Map<String, String> params);
    List<Phonghoc> getPhonghocs (Map<String, String> params);
    List<Nganhdaotao> getNganhdaotaos (Map<String, String> params);
}
