/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.av.repository;

import com.av.pojo.Lophoc;
import com.av.pojo.Nganhdaotao;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface DaoTaoRepository {
    List<Lophoc> listLopHoc();
    Lophoc getLopById(int idLop);
}
