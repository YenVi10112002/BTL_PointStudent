/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.av.service;

import com.av.pojo.Sinhvien;
import com.av.pojo.Taikhoan;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface TaiKhoanService {
   boolean updateImg(Taikhoan s);  
   Taikhoan getTaiKhoan(int idTaiKhoan);
   boolean addAcount(Taikhoan t);
    boolean addAcountGV(Taikhoan t);
    List<Taikhoan> getTaiKhoan();
}

