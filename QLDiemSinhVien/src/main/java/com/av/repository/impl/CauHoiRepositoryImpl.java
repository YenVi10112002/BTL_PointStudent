/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.repository.impl;

import com.av.pojo.Cauhoidiendang;
import com.av.pojo.Giangvien;
import com.av.pojo.Sinhvien;
import com.av.repository.CauHoiRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class CauHoiRepositoryImpl implements CauHoiRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    @Override
    public List<Cauhoidiendang> getCauhoidiendangs() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Cauhoidiendang");
        
        return q.getResultList();
    }  

    @Override
    public Cauhoidiendang getCauHoi(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        if (params != null) {
            String cateId = params.get("cauhoiId");
            if (cateId != null) {
               Query q = s.createQuery("From Cauhoidiendang WHERE idCauHoiDienDan =:idCauHoi"); 
               q.setParameter("idCauHoi", Integer.parseInt(cateId));
               Cauhoidiendang cauhoi =(Cauhoidiendang) q.getSingleResult();
               return cauhoi;
            }
        }
        return null;
        
    }

 
}
