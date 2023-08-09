/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.repository.impl;

import com.av.pojo.Cauhoidiendang;
import com.av.pojo.Giangvien;
import com.av.pojo.Sinhvien;
import com.av.pojo.Traloidiendan;
import com.av.repository.CauHoiRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;

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
public class CauHoiRepositoryImpl implements CauHoiRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public Object getCauHoi(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root<Cauhoidiendang> rCauHoi = q.from(Cauhoidiendang.class);
        Root<Sinhvien> rSinhVien = q.from(Sinhvien.class);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String cateId = params.get("cauhoiId");
            if (cateId != null) {
                predicates.add(b.equal(rCauHoi.get("idCauHoiDienDan"), Integer.parseInt(cateId)));
                predicates.add(b.equal(rCauHoi.get("idTaiKhoan"), rSinhVien.get("idTaiKhoan")));
            }
            q.select(b.array(rCauHoi.get("noiDungCauHoi"), rCauHoi.get("idCauHoiDienDan"), rSinhVien.get("hoTen")))
                    .where(predicates.toArray(Predicate[]::new));
        }

        q.groupBy(rCauHoi.get("idCauHoiDienDan"));
        Query query = session.createQuery(q);
        try {
            return query.getSingleResult();
        } catch (NoResultException | NonUniqueResultException ex) {

            ex.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public boolean addOrUpdateTraloi(Traloidiendan p) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (p.getNoiDungTraLoi() == null) {
                return false;
            } else {
                if (p.getIdTraLoiDienDan() == null) {
                    s.save(p);
                } else {
                    s.update(p);
                }
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public List<Object> getCauHoiDienDan() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root<Cauhoidiendang> rCauHoi = q.from(Cauhoidiendang.class);
        Root<Sinhvien> rSinhVien = q.from(Sinhvien.class);

        q.select(b.array(rCauHoi.get("noiDungCauHoi"), rCauHoi.get("idCauHoiDienDan"), rSinhVien.get("hoTen")))
                .where(b.equal(rCauHoi.get("idTaiKhoan"), rSinhVien.get("idTaiKhoan")));

        q.groupBy(rCauHoi.get("idCauHoiDienDan"));
        Query query = s.createQuery(q);
        try {
            return query.getResultList();
        } catch (NoResultException | NonUniqueResultException ex) {

            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Object> getTraLoi(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root<Traloidiendan> rTraLoi = q.from(Traloidiendan.class);
        Root<Sinhvien> rSinhVien = q.from(Sinhvien.class);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String cateId = params.get("cauhoiId");
            if (cateId != null) {
                predicates.add(b.equal(rTraLoi.get("idCauHoiDienDan"), Integer.parseInt(cateId)));
                predicates.add(b.equal(rTraLoi.get("idTaiKhoan"), rSinhVien.get("idTaiKhoan")));
            }
            q.select(b.array(rTraLoi.get("noiDungTraLoi"), rTraLoi.get("idTraLoiDienDan"), rSinhVien.get("hoTen")))
                    .where(predicates.toArray(Predicate[]::new));
        }

        q.orderBy(b.desc(rTraLoi.get("idTraLoiDienDan")));
        q.groupBy(rTraLoi.get("idTraLoiDienDan"));
        Query query = session.createQuery(q);
        try {
            return query.getResultList();
        } catch (NoResultException | NonUniqueResultException ex) {

            ex.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public boolean addOrUpdateCauHoi(Cauhoidiendang p) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (p.getNoiDungCauHoi() == null) {
                return false;
            } else {
                if (p.getIdCauHoiDienDan() == null) {
                    s.save(p);
                } else {
                    s.update(p);
                }
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
