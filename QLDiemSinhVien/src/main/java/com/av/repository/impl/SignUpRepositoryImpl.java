/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.repository.impl;

import com.av.pojo.Taikhoan;
import com.av.repository.SignUpRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author FPTSHOP
 */
@Repository
@Transactional
public class SignUpRepositoryImpl implements SignUpRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public boolean addOrUpdateAcount(Taikhoan t) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (t.getIdTaiKhoan() == null) {
                s.save(t);
            }
            else
                s.update(t);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }

    }

}
