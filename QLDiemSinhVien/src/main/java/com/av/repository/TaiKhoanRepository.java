/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.av.repository;

import com.av.pojo.Loaitaikhoan;
import com.av.pojo.Sinhvien;
import com.av.pojo.Taikhoan;
import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
public interface TaiKhoanRepository {
    boolean updateImg(Taikhoan s);
    Taikhoan getTaiKhoan(int idTaiKhoan);
    boolean addAcount(Taikhoan t);
    boolean addAcountGV(Taikhoan t);
    List<Taikhoan> getTaiKhoan();
    Loaitaikhoan getChucVu(int id);
    Taikhoan getUserByUsername(String username);
    boolean authUser(String username, String password);
    Taikhoan addUser(Taikhoan user);
    boolean kiemTraTaiKhoan (Taikhoan user);
    Taikhoan thayDoiMatKhau(Taikhoan a);
//    Taikhoan getTaikhoanBySinhVien(int idSinhVien);
//    boolean deleteTaiKhoanBySinhVien(int idSinhVien);
    boolean deleteTK(Taikhoan tk);
    
}
