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
public interface SignUpRepository {
    boolean addAcount(Taikhoan t);
    boolean addAcountGV(Taikhoan t);
    List<Taikhoan> getTaiKhoan();

    
    
    
}

