/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.av.service;

import com.av.pojo.Diem;
import com.av.pojo.Lophoc;
import com.av.pojo.Sinhvien;
import com.av.pojo.Taikhoan;
import com.av.pojo.Traloidiendan;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface SinhVienService {
    Sinhvien getSinhvien(int idTaiKhoan);
    List<Sinhvien> getSinhviens(Map<String, String> params);
    List<Lophoc> getLopHocs();
    boolean addOrUpdateSinhVien(Sinhvien sv );
    Sinhvien getSinhVienById(int idSinhVien);
    boolean deleteSinhVien(int idSinhVien);
    List<Object> getSinhvienByMonHoc(Map<String, String> params);
    
    Long countSinhVien();
    
    //update 26/9 danh sach sinh vien theo ma lop
    List<Sinhvien> getSinhVienByIdLop(int idLop);
    
}
