/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.repository.impl;

import com.av.pojo.Taikhoan;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.av.repository.LoginRepository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

import javax.persistence.criteria.Root;

/**
 *
 * @author FPTSHOP
 */
@Repository
@Transactional
public class LoginRepositoryImpl implements LoginRepository {

    @Autowired
    private LocalSessionFactoryBean Factory;

//    @Override
//    public List<Taikhoan> getTaikhoans(String tenTK) {
//        Session s = this.Factory.getObject().getCurrentSession();
//        CriteriaBuilder builder = s.getCriteriaBuilder();
//        CriteriaQuery<Taikhoan> query = builder.createQuery(Taikhoan.class);
//        Root root = query.from(Taikhoan.class);
//        query = query.select(root);
//        
//        if(!tenTK.isEmpty()){
//            Predicate p = builder.equal(root.get("tenTaiKhoan").as(String.class), tenTK.trim());
//            query = query.where(p);
//        }
//        
//        Query q = s.createQuery(query);
//        return q.getResultList();
//    }
    @Override
    public Taikhoan getUserByUsername(String username) {
        Session s = this.Factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Taikhoan Where tenTaiKhoan=:un");
        q.setParameter("un", username);
        return (Taikhoan) q.getSingleResult();
    }
}
