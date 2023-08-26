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

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author FPTSHOP
 */
@Repository
@Transactional
public class LoginRepositoryImpl implements LoginRepository {

    @Autowired
    private LocalSessionFactoryBean Factory;
    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Override
    public Taikhoan getUserByUsername(String username) {
        Session s = this.Factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Taikhoan Where tenTaiKhoan=:un");
        q.setParameter("un", username);
        return (Taikhoan) q.getSingleResult();
    }

    @Override
    public boolean authUser(String username, String password) {
        Taikhoan u = this.getUserByUsername(username);

        return this.passEncoder.matches(password, u.getMatKhau());
    }

    @Override
    public Taikhoan addUser(Taikhoan u) {
        Session s = this.Factory.getObject().getCurrentSession();
        s.save(u);
        return u;
    }

}
