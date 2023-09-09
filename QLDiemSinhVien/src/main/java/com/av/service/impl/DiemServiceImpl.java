/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.service.impl;

import com.av.pojo.Diem;
import com.av.repository.DiemRepository;
import com.av.service.DiemService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
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
    public Diem addDiem(Diem diem1) {
        Diem diem = this.diemRepository.getDiemByIdDIem(diem1.getIdDiem());
        Double diemTB = 0.0;
        String xepLoai;
        Short trangThai;

        if (diem1.getDiemKT1() == null) {
            diemTB = (diem1.getDiemGiuaKy() + diem1.getDiemCuoiKy()) * 0.5;
        } else if (diem1.getDiemTK2() == null) {
            diemTB = (diem1.getDiemGiuaKy() * 0.4 + diem1.getDiemKT1() * 0.1 + diem1.getDiemCuoiKy() * 0.5);

        } else if (diem1.getDiemTK3() == null) {
            diemTB = (diem1.getDiemGiuaKy() * 0.3 + diem1.getDiemKT1() * 0.1 + diem1.getDiemTK2() * 0.1 + diem1.getDiemCuoiKy() * 0.5);

        } else {
            diemTB = (diem1.getDiemGiuaKy() * 0.2 + (diem1.getDiemKT1() + diem1.getDiemTK2() + diem1.getDiemTK3()) * 0.1 + diem1.getDiemCuoiKy() * 0.5);

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
        diem.setDiemCuoiKy(diem1.getDiemCuoiKy());
        diem.setDiemGiuaKy(diem1.getDiemGiuaKy());
        diem.setDiemKT1(diem1.getDiemKT1());
        diem.setDiemTK2(diem1.getDiemTK2());
        diem.setDiemTK3(diem1.getDiemTK3());

        // Lưu vào repository
        this.diemRepository.addDiem(diem);

        return diem;
    }

    @Override
    public String getDiemByCSV(Map<String, String> params, MultipartFile file) {

        if (!file.isEmpty()) {
            String idMonHoc = params.get("idMonHoc");
            try (CSVParser parser = CSVParser.parse(file.getInputStream(), StandardCharsets.UTF_8, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
                for (CSVRecord record : parser) {
                    String idSinhVien = record.get("idSinhVien");
                    String diemGiuaKy = record.get("diemGiuaKy");
                    String diemCuoiKy = record.get("diemCuoiKy");
                    String diemTK1 = record.get("diemTK1");
                    String diemTK2 = record.get("diemTK2");
                    String diemTK3 = record.get("diemTK3");
//
                    Diem diem = this.diemRepository.getDiemByIdMonHoc(Integer.parseInt(idMonHoc), Integer.parseInt(idSinhVien));
                    if (diem != null) {
                        diem.setDiemGiuaKy(Double.parseDouble(diemGiuaKy));
                        diem.setDiemCuoiKy(Double.parseDouble(diemCuoiKy));
                        diem.setDiemKT1(Double.parseDouble(diemTK1));
                        diem.setDiemTK2(Double.parseDouble(diemTK2));
                        diem.setDiemTK3(Double.parseDouble(diemTK3));
//                        
                        this.addDiem(diem);// Cập nhật điểm trong cơ sở dữ liệu
                    }
                }

                return "oke";
            } catch (IOException ex) {
                Logger.getLogger(DiemServiceImpl.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
        return "oke";
    }

    @Override
    public Diem getDiemByIdMonHoc(int idMonHoc, int idSinhVien
    ) {

        return this.diemRepository.getDiemByIdMonHoc(idMonHoc, idSinhVien);
    }

    @Override
    public Diem getDiemByIdDiem(Map<String, String> params) {
        String idDiem = params.get("idDiem");
        Diem diem = this.diemRepository.getDiemByIdDIem(Integer.parseInt(idDiem));
        return diem;
    }

    @Override
    public List<Diem> getDiemByidGiangVien(Map<String, String> params) {
        return this.diemRepository.getDiemByidGiangVien(params);
    }

    @Override
    public boolean khoaDiem(Map<String, String> params) {
        return this.diemRepository.khoaDiem(params);
    }

    @Override
    public boolean deleteDiem(int idMonHoc, int idSinhVien) {
        return this.diemRepository.deleteDiem(idMonHoc, idSinhVien);
    }
    
}
