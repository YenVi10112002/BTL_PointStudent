/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.repository.impl;

import com.av.pojo.Cauhoidiendang;
import com.av.pojo.Sinhvien;
import com.av.repository.ListSinhVienRepository;
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
public class ListSinhVienRepositoryImpl implements ListSinhVienRepository{
     @Autowired
    private LocalSessionFactoryBean factory;
    @Override
    public List<Sinhvien> getSinhviens(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
       
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Sinhvien> q = b.createQuery(Sinhvien.class);
        Root root = q.from(Sinhvien.class);
        q.select(root);
        if(params != null)
        {
            
            String idSV = params.get("idSinhVien");
            if(idSV != null && !idSV.isEmpty())
                q.where(b.equal(root.get("idSinhVien"), Integer.parseInt(idSV)));
        }
        Query query = session.createQuery(q);
        return query.getResultList();
    } 
}
