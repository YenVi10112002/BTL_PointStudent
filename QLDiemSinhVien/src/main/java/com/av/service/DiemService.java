/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.av.service;

import java.util.List;

/**
 *
 * @author Admin
 */
public interface DiemService {
    double getDiemTrungBinh(int sinhvienId);
    double getDiemTrungBinhHe(int sinhvienId);
    List<Object> getListDiem(int sinhvienId);
    List<Object> getListDiemTrungBinh(int sinhvienId);
}
