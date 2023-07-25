/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.repository.impl;

import com.av.pojo.Cauhoidiendang;
import com.av.pojo.Sinhvien;
import com.av.repository.ListSinhVienRepository;
import java.util.List;
import javax.persistence.Query;
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
public class ListSinhVienRepositoryImpl implements ListSinhVienRepository{
     @Autowired
    private LocalSessionFactoryBean factory;
    @Override
    public List<Sinhvien> getSinhviens() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Sinhvien");
        
        return q.getResultList();
    } 
}
