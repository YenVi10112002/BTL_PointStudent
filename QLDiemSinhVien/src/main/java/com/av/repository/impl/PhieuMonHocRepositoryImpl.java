/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.repository.impl;

import com.av.pojo.PhieuMonHoc;
import com.av.pojo.Diem;
import com.av.repository.MonHocRepository;
import com.av.repository.PhieuMonHocRepository;
import com.av.repository.SinhVienRepository;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author FPTSHOP
 */
@Repository
public class PhieuMonHocRepositoryImpl implements PhieuMonHocRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private SinhVienRepository svRepository;

    @Autowired
    private MonHocRepository mhRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addPhieuMH(Map<String, PhieuMonHoc> carts) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            for (PhieuMonHoc c : carts.values()) {
                Diem d = new Diem();
                d.setIdMonHoc(mhRepository.getMonHocById(c.getIdMonHoc()));
                d.setIdSinhVien(svRepository.getSinhVienById(c.getIdSinhVien()));
                s.save(d);

            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }

    }
    @Override
    public PhieuMonHoc getPhieuMonHoc() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From PhieuMonHoc");
        return (PhieuMonHoc) q.getSingleResult();
    }

}
