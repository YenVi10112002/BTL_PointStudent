/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.av.repository;

import com.av.pojo.Monhoc;
import com.av.pojo.PhieuMonHoc;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public interface MonHocRepository {
    List<Monhoc> getMonHocs();
    boolean addOrUpdateMonHoc(Monhoc mh);
    Monhoc getMonHocById(int id);
    boolean deleteMonHoc(int id);
    
}
