///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.av.repository.impl;
//
//import com.av.pojo.Taikhoan;
//import com.av.repository.UserRepository;
//import javax.persistence.Query;
//import org.hibernate.Session;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// *
// * @author Admin
// */
//@Repository
//@Transactional
//public class UserRepositoryImpl implements UserRepository {
//
//    @Autowired
//    private LocalSessionFactoryBean factory;
//    @Autowired
//    private BCryptPasswordEncoder passEncoder;
//
//    @Override
//    public Taikhoan getUserByUserName(String username) {
//        Session s = this.factory.getObject().getCurrentSession();
//        Query q = s.createQuery("FROM Taikhoan WHERE tenTaiKhoan=:un");
//        q.setParameter("un", username);
//
//        return (Taikhoan) q.getSingleResult();
//    }
//
//    @Override
//    public boolean authUser(String username, String password) {
//        Taikhoan  u = this.getUserByUserName(username);
//        
//        return this.passEncoder.matches(password, u.getMatKhau());
//    }
//
//    @Override
//    public Taikhoan addUser(Taikhoan u) {
//        Session s = this.factory.getObject().getCurrentSession();
//        s.save(u);
//     
//        return u;
//    }
//
//}
