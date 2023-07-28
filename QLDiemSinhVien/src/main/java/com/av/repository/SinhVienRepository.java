/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.av.repository;

import com.av.pojo.Diem;
import com.av.pojo.Sinhvien;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface SinhVienRepository {
    Sinhvien getSinhVien(int sinhvienId);
    
    int getHocKy();
    
    double getDiemTrungBinh(int sinhvienId);
    List<Diem> DiemByMonHoc(); 
}
