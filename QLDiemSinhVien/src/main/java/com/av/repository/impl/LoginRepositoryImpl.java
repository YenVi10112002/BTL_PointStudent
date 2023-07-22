/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.repository.impl;

import com.av.pojo.Loaitaikhoan;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.av.repository.LoginRepository;

/**
 *
 * @author FPTSHOP
 */
@Repository
@Transactional
public class LoginRepositoryImpl implements LoginRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    @Override
    public List<Loaitaikhoan> getLoaitaikhoans() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Loaitaikhoan");
        
        return q.getResultList();
    }
    
}
