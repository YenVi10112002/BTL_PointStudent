/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.av.service;

import com.av.pojo.Diem;
import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
public interface DiemService {
    double getDiemTrungBinh(int sinhvienId);
    double getDiemTrungBinhHe(int sinhvienId);
    double getDiemTrungBinh2(Map<String, String> params);
    double getDiemTrungBinhHe4(Map<String, String> params);
    List<Object> getListDiem(int sinhvienId);
    List<Object> getListDiemTrungBinh(int sinhvienId);
    List<Object> getListDiemTrungBinh2(Map<String, String> params);
    List<Object> getListDiem2(Map<String, String> params);
    Diem addDiem(Diem diem);
    List<Diem> getDiemByCSV(Map<String, String> params, MultipartFile file);
    List<Diem> getDiemByIdMonHoc(int idMonHoc, int idSinhVien);
}
