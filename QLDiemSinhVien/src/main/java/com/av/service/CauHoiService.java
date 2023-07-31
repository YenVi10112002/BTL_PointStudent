/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.av.service;

import com.av.pojo.Cauhoidiendang;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface CauHoiService {
    List<Cauhoidiendang> getCauhoidiendangs();
    Cauhoidiendang getCauHoi(Map<String, String> params);
}
