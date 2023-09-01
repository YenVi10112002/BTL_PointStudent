/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.service.impl;

import com.av.pojo.Diem;
import com.av.repository.DiemRepository;
import com.av.service.DiemService;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Service
public class DiemServiceImpl implements DiemService {

    @Autowired
    private DiemRepository diemRepository;

    @Override
    public double getDiemTrungBinh(int sinhvienId) {
        return diemRepository.getDiemTrungBinh(sinhvienId);
    }

    @Override
    public double getDiemTrungBinhHe(int sinhvienId) {
        return diemRepository.getDiemTrungBinhHe(sinhvienId);
    }

    @Override
    public List<Object> getListDiem(int sinhvienId) {
        return diemRepository.getListDiem(sinhvienId);
    }

    @Override
    public List<Object> getListDiemTrungBinh(int sinhvienId) {
        return diemRepository.getListDiemTrungBinh(sinhvienId);
    }

    @Override
    public List<Object> getListDiemTrungBinh2(Map<String, String> params) {
        return diemRepository.getListDiemTrungBinh2(params);
    }

    @Override
    public double getDiemTrungBinh2(Map<String, String> params) {
        return diemRepository.getDiemTrungBinh2(params);
    }

    @Override
    public double getDiemTrungBinhHe4(Map<String, String> params) {
        return diemRepository.getDiemTrungBinhHe4(params);
    }

    @Override
    public List<Object> getListDiem2(Map<String, String> params) {
        return diemRepository.getListDiem2(params);
    }

    @Override
    public Diem addDiem(Diem diem) {
        Double diemTB = 0.0;
        String xepLoai;
        Short trangThai;

        if (diem.getDiemKT1() == null) {
            diemTB = (diem.getDiemGiuaKy() + diem.getDiemCuoiKy()) * 0.5;
        } else if (diem.getDiemTK2() == null) {
            diemTB = (diem.getDiemGiuaKy() * 0.4 + diem.getDiemKT1() * 0.1 + diem.getDiemCuoiKy() * 0.5);
        } else if (diem.getDiemTK3() == null) {
            diemTB = (diem.getDiemGiuaKy() * 0.3 + diem.getDiemKT1() * 0.1 + diem.getDiemTK2() * 0.1 + diem.getDiemCuoiKy() * 0.5);
        } else {
            diemTB = (diem.getDiemGiuaKy() * 0.2 + (diem.getDiemKT1() + diem.getDiemTK2() + diem.getDiemTK3()) * 0.1 + diem.getDiemCuoiKy() * 0.5);
        }

        // Tính trạng thái dựa trên điểm trung bình
        DecimalFormat decimalFormat = new DecimalFormat("#.#", new DecimalFormatSymbols(Locale.US));
        diemTB = Double.valueOf(decimalFormat.format(diemTB));

        if (diemTB >= 5) {
            trangThai = 1;
        } else {
            trangThai = 0;
        }

        if (diemTB >= 9) {
            xepLoai = "Giỏi";
        } else if (diemTB >= 6.5) {
            xepLoai = "Khá";
        } else if (diemTB >= 5) {
            xepLoai = "Trung Bình";
        } else {
            xepLoai = "Yếu";
        }

        // Đặt điểm trung bình và trạng thái
        diem.setDiemTrungBình(diemTB);
        diem.setTrangThai(trangThai);
        diem.setXepLoai(xepLoai);

        // Lưu vào repository
        this.diemRepository.addDiem(diem);

        return diem;
    }

    @Override
    public List<Diem> getDiemByCSV(Map<String, String> params, MultipartFile file) {
        List<Diem> updatedDiemList = new ArrayList<>();
        if (!file.isEmpty()) {
            try (
                    CSVParser parser = CSVParser.parse(new FileReader((File) file), CSVFormat.DEFAULT);) {
                String idMonHoc = params.get("idMonHoc");

                for (CSVRecord record : parser) {
                    int idSinhVien = Integer.parseInt(record.get("idSinhVien"));
                    Double diemGiuaKy = Double.valueOf(record.get("diemGiuaKy"));
                    Double diemCuoiKy = Double.valueOf(record.get("diemCuoiKy"));
                    Double diemTK1 = Double.valueOf(record.get("diemTK1"));
                    Double diemTK2 = Double.valueOf(record.get("diemTK2"));
                    Double diemTK3 = Double.valueOf(record.get("diemTK3"));

                    Diem diem = (Diem) this.diemRepository.getDiemByIdMonHoc(Integer.parseInt(idMonHoc), idSinhVien);
                    if (diem != null) {
                        diem.setDiemCuoiKy(diemCuoiKy);
                        diem.setDiemGiuaKy(diemGiuaKy);
                        diem.setDiemKT1(diemTK1);
                        diem.setDiemTK2(diemTK2);
                        diem.setDiemTK3(diemTK3);
                        this.diemRepository.addDiem(this.addDiem(diem));
                        updatedDiemList.add(diem);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(DiemServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                return updatedDiemList;
            }

        }
        return updatedDiemList;
    }

    @Override
    public List<Diem> getDiemByIdMonHoc(int idMonHoc, int idSinhVien
    ) {

        return this.diemRepository.getDiemByIdMonHoc(idMonHoc, idSinhVien);
    }

}
