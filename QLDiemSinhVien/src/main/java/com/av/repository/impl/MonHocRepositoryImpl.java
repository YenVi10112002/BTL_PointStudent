/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.repository.impl;

import com.av.pojo.Diem;
import com.av.pojo.Giangvien;
import com.av.pojo.Monhoc;
import com.av.pojo.MonhocHocky;
import com.av.pojo.Monhocdangky;
import com.av.repository.MonHocRepository;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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

    @Override
    public List<Monhoc> getMonHocByGiangVien(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rMonHoc = q.from(MonhocHocky.class);
        Root rGiangVien = q.from(Giangvien.class);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String idTaiKhoan = params.get("taiKhoanId");
            if (idTaiKhoan != null) {
                predicates.add(b.equal(rGiangVien.get("idTaiKhoan"), Integer.parseInt(idTaiKhoan)));
                predicates.add(b.equal(rMonHoc.get("idGiangVien"), rGiangVien.get("idGiangVien")));
            }
            q.select(rMonHoc).where(predicates.toArray(Predicate[]::new));
            q.groupBy(rMonHoc.get("idMonHocHocKy"));
            Query query = s.createQuery(q);
            return query.getResultList();
        }
        return null;

    }

    //Update
    @Override
    public Long CountMonHocInGV(int idGiangVien) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Long> q = b.createQuery(Long.class);

        Root r = q.from(Monhoc.class);
        q.select(b.count(r)).where(b.equal(r.get("idGiangVien").get("idGiangVien"), idGiangVien));

        long countMonHoc = session.createQuery(q).uniqueResult();

        return countMonHoc;

    }

    @Override
    public List<Monhoc> getMonHocByIdSinhVien(int idSinhvien) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rMonHoc = q.from(Monhocdangky.class);
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.equal(rMonHoc.get("idSinhVien"), idSinhvien));
        predicates.add(b.equal(rMonHoc.get("trangThai"), 1));
        predicates.add(b.equal(rMonHoc.get("khoaMon"), 1));
        q.select(rMonHoc).where(predicates.toArray(Predicate[]::new));
        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Monhoc> getMonHocByIdSinhVienDangHoc(int idSinhvien) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rMonHoc = q.from(Monhocdangky.class);
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.equal(rMonHoc.get("idSinhVien"), idSinhvien));
        predicates.add(b.equal(rMonHoc.get("khoaMon"), 0));
        q.select(rMonHoc).where(predicates.toArray(Predicate[]::new));
        Query query = s.createQuery(q);
        return query.getResultList();
    }

}
