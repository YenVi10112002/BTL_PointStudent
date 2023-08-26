/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.av.service;

import com.av.pojo.Diem;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface DiemService {
    double getDiemTrungBinh(int sinhvienId);
    double getDiemTrungBinhHe(int sinhvienId);
    boolean addDiem(Diem d);

}

