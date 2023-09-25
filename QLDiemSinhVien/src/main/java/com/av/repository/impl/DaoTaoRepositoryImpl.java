/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.repository.impl;

import com.av.pojo.Lophoc;
import com.av.pojo.Nganhdaotao;
import com.av.repository.DaoTaoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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
public class DaoTaoRepositoryImpl implements DaoTaoRepository{

    @Autowired
    private LocalSessionFactoryBean factory;
    

    @Override
    public List<Lophoc> listLopHoc() {
       Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root<Lophoc> rLop = q.from(Lophoc.class);

        q.select(b.array(rLop));
        q.orderBy(b.asc(rLop.get("idNganh")));

        Query query = s.createQuery(q);
        try {
            return query.getResultList();
        } catch (NoResultException | NonUniqueResultException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    

    @Override
    public Lophoc getLopById(int idLop) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root<Lophoc> rLop = q.from(Lophoc.class);

        q.select(b.array(rLop));
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rLop.get("idLopHoc"), idLop));
        q.where(predicates.toArray(Predicate[]::new));
        Query query = s.createQuery(q);
        try {
            return (Lophoc) query.getSingleResult();
        } catch (NoResultException | NonUniqueResultException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    
}
