/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.av.repository;


import com.av.pojo.Taikhoan;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public interface LoginRepository {
//    List<Loaitaikhoan> getLoaitaikhoans();
//    List<Taikhoan> getTaikhoans(String tenTK);
    Taikhoan getUserByUsername(String username);
    
}
