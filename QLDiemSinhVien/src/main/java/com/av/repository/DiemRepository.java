/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.av.repository;

import java.util.List;
import java.util.Map;



/**
 *
 * @author Admin
 */
public interface DiemRepository {
        double getDiemTrungBinh(int sinhvienId);
        double getDiemTrungBinhHe(int sinhvienId);
        double getDiemTrungBinh2(Map<String, String> params);
        double getDiemTrungBinhHe4(Map<String, String> params);
        List<Object> getListDiem(int sinhvienId);
        List<Object> getListDiemTrungBinh(int sinhvienId);
        List<Object> getListDiemTrungBinh2(Map<String, String> params);
        List<Object> getListDiem2(Map<String, String> params);

}
