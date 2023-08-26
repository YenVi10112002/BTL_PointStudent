/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.av.service;

import com.av.pojo.Monhoc;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public interface MonHocService {
    List<Monhoc> getMonHocs();
    boolean addOrUpdateMonHoc(Monhoc mh);
    Monhoc getMonHocById(int id);
    boolean deleteMonHoc(int id);
}