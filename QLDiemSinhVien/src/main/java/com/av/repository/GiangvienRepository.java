/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.av.repository;

import com.av.pojo.Giangvien;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public interface GiangvienRepository {
    List<Giangvien> getGiangviens();
    boolean addOrUpdateGiangVien(Giangvien sv);
    Giangvien getGiangVienById(int idGiangVien);
    Giangvien getGiangVienByIdTaiKhoan(int idTaiKhoan);
    boolean deleteGV(int idGiangVien);
    
}
