/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.repository.impl;

import com.av.pojo.Giangvien;
import com.av.pojo.Sinhvien;
import com.av.pojo.Taikhoan;
import com.av.repository.GiangvienRepository;
import java.util.ArrayList;
import java.util.List;
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
 * @author FPTSHOP
 */
@Repository
@Transactional
public class GiangvienRepositoryImpl implements GiangvienRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Giangvien> getGiangviens() {
        Session session = this.factory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Giangvien> q = b.createQuery(Giangvien.class);
        Root root = q.from(Giangvien.class);
        q.select(root);
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public boolean addOrUpdateGiangVien(Giangvien gv) {
        Session s = this.factory.getObject().getCurrentSession();
        
        try {
            if (gv.getIdGiangVien() == null) {
                s.save(gv);
            } else {
                s.update(gv);
            }

            return true;
        } catch (HibernateException e) {
            e.printStackTrace();

        }
        return false;
    }

    @Override
    public Giangvien getGiangVienById(int idGiangVien) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Giangvien> q = b.createQuery(Giangvien.class);

        Root r = q.from(Giangvien.class);
        q.select(r);

        q.where(b.equal(r.get("idGiangVien"), idGiangVien));

        Query query = session.createQuery(q);
        return (Giangvien) query.getSingleResult();
    }

    @Override
    public boolean deleteGV(int idGiangVien) {
        Session session = this.factory.getObject().getCurrentSession();
        Giangvien gv = this.getGiangVienById(idGiangVien);
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Taikhoan> q = b.createQuery(Taikhoan.class);
        Root r = q.from(Taikhoan.class);
        q.select(r).where(b.equal(r.get("idTaiKhoan"), gv.getIdTaiKhoan().getIdTaiKhoan()));
        Query query = session.createQuery(q);
        
        try {
            if (gv.getIdTaiKhoan().getIdTaiKhoan() != null) {
                Taikhoan tk = (Taikhoan) query.getSingleResult();
                session.delete(gv);
                session.delete(tk);
            }
            session.remove(gv);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public Giangvien getGiangVienByIdTaiKhoan(int idTaiKhoan) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Giangvien> q = b.createQuery(Giangvien.class);

        Root<Giangvien> root = q.from(Giangvien.class);
        q.select(root);
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.equal(root.get("idTaiKhoan"), idTaiKhoan));
        q.where(predicates.toArray(new Predicate[0]));
        Query query = session.createQuery(q);
        try {
            return (Giangvien) query.getSingleResult();
        } catch (NoResultException | NonUniqueResultException ex) {

            ex.printStackTrace();
            return null;
        }
    }

}
