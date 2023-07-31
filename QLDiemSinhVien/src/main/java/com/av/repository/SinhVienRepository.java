/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.av.repository;

import com.av.pojo.Diem;
import com.av.pojo.Sinhvien;
import com.av.pojo.Traloidiendan;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface SinhVienRepository {
    List<Sinhvien> getSinhVien(int idTaiKhoan);
    
    int getHocKy();
    
    List<Traloidiendan> getTraLoi(Map<String, String> params);
}