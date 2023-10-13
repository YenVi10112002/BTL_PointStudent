/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.av.repository;

import com.av.pojo.Hedaotao;
import com.av.pojo.Hocky;
import com.av.pojo.Khoa;
import com.av.pojo.Khoadaotao;
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
    
    
    ////delete
    ///Tìm danh sách các đối tượng liên quan
    List<Lophoc> getLopByIdHeDaoTao(int id);  
    List<Lophoc> getLopByIdKhoaHoc(int id); 
    List<Nganhdaotao> getNganhDaoTaoByIdKhoa(int idKhoa);
    List<Hocky> getHocKyByIdLop(int idLop);
    /// Tìm đối tượng cần xóa
    Khoa getKhoaHocById(int id);
    Hedaotao getHeDaoTaoById(int id);
    Khoadaotao getKhoaDaoTaoById(int idKhoa);
    Lophoc getLopHocByIdLop(int idLop);
    
    
    //Xóa đối tượng
    Boolean deleteHeDaoTao(int id);
    Boolean deleteKhoaHoc(int idKhoa);
    Boolean deleteKhoaDaoTao(int id);
    Boolean deleteLopHoc(int idLop);
    
}
