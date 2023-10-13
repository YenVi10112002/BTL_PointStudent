/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.service.impl;

import com.av.pojo.Lophoc;
import com.av.pojo.Nganhdaotao;
import com.av.repository.DaoTaoRepository;
import com.av.service.DaoTaoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class DaoTaoServiceImpl implements DaoTaoService{

    @Autowired
    private DaoTaoRepository daoTao;
    
    

    @Override
    public List<Lophoc> listLopHoc() {
        return this.daoTao.listLopHoc();
    }

    @Override
    public Lophoc getLopById(int idLop) {
        return this.daoTao.getLopById(idLop);
    }

    ////delete
    @Override
    public Boolean deleteHeDaoTao(int id) {
        return this.daoTao.deleteHeDaoTao(id);
    }
    @Override
    public Boolean deleteKhoaDaoTao(int id) {
        return this.daoTao.deleteKhoaDaoTao(id);
    }
    @Override
    public Boolean deleteLopHoc(int idLop) {
        return this.daoTao.deleteLopHoc(idLop);
    }
    @Override
    public Boolean deleteKhoaHoc(int idKhoa) {
        return this.daoTao.deleteKhoaHoc(idKhoa);
    }
       
}
