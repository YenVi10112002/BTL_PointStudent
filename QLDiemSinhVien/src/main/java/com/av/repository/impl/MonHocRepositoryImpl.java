/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.repository.impl;

import com.av.pojo.Monhoc;
import com.av.pojo.PhieuMonHoc;
import com.av.repository.MonHocRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 *
 * @author FPTSHOP
 */
@Repository
@Transactional
public class MonHocRepositoryImpl implements MonHocRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Monhoc> getMonHocs() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Monhoc");
        return q.getResultList();
    }

    @Override
    public boolean addOrUpdateMonHoc(Monhoc mh) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (mh.getIdMonHoc() == null) {
                s.save(mh);
            } else {
                s.update(mh);
            }
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();

        }
        return false;
    }

    @Override
    public Monhoc getMonHocById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Monhoc> q = b.createQuery(Monhoc.class);

        Root r = q.from(Monhoc.class);
        q.select(r);

        q.where(b.equal(r.get("idMonHoc"), id));

        Query query = session.createQuery(q);
        return (Monhoc) query.getSingleResult();

    }

    @Override
    public boolean deleteMonHoc(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        Monhoc mh = this.getMonHocById(id);
        try {
            session.delete(mh);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    

}
