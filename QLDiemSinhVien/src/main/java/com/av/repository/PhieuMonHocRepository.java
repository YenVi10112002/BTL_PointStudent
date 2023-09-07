/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.av.repository;

import com.av.pojo.PhieuMonHoc;
import java.util.Map;

/**
 *
 * @author FPTSHOP
 */
public interface PhieuMonHocRepository {
    boolean addPhieuMH(Map<String, PhieuMonHoc> carts);
    PhieuMonHoc getPhieuMonHoc();
    boolean deletePhieuMH(int idMonHoc);
    PhieuMonHoc getPhieuMonHocByIdMh(int idMonHoc);
    PhieuMonHoc getPhieuMonHocByIdSv(int idSinhVien);
}
