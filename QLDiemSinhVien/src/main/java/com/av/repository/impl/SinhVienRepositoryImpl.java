/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.repository.impl;

import com.av.pojo.Diem;
import com.av.pojo.Lophoc;
import com.av.pojo.Monhoc;
import com.av.pojo.Sinhvien;
import com.av.pojo.Taikhoan;
import com.av.pojo.Traloidiendan;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.av.repository.SinhVienRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.Propagation;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class SinhVienRepositoryImpl implements SinhVienRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public Sinhvien getSinhVien(int idTaiKhoan) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Sinhvien> q = b.createQuery(Sinhvien.class);

        Root<Sinhvien> root = q.from(Sinhvien.class);
        q.select(root);
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.equal(root.get("idTaiKhoan"), idTaiKhoan));
        q.where(predicates.toArray(new Predicate[0]));
        Query query = session.createQuery(q);
        try {
            return (Sinhvien) query.getSingleResult();
        } catch (NoResultException | NonUniqueResultException ex) {

            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public int getHocKy() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT MAX(hocKy) FROM Monhoc");
        Integer maxValue = (Integer) q.getSingleResult();
        return maxValue;
    }

    @Override
    public Taikhoan getTaiKhoan(int idTaiKhoan) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Taikhoan> q = b.createQuery(Taikhoan.class);

        Root<Taikhoan> root = q.from(Taikhoan.class);
        q.select(root);
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.equal(root.get("idTaiKhoan"), idTaiKhoan));
        q.where(predicates.toArray(new Predicate[0]));
        Query query = session.createQuery(q);
        try {
            return (Taikhoan) query.getSingleResult();
        } catch (NoResultException | NonUniqueResultException ex) {

            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Lophoc> getLopHocs() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Lophoc");
        return q.getResultList();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addOrUpdateSinhVien(Sinhvien sv) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (sv.getIdSinhVien() == null) {
                s.save(sv);
//                Diem diem = new Diem();
//                diem.setIdSinhVien(sv);
//                s.save(diem);
            } else {
//                CriteriaBuilder b = s.getCriteriaBuilder();
//                CriteriaQuery<Diem> q = b.createQuery(Diem.class);
//                Root<Diem> root = q.from(Diem.class);
//                q.select(root).where(b.equal(root.get("idSinhVien"), sv));
//                Query query = s.createQuery(q);
//                Diem d = (Diem) query.getSingleResult();
//                if (d.getIdSinhVien() != null) {
                    s.update(sv);
//                    d.setIdMonHoc(sv.getMonhoc());
//                    s.update(d);
//                }
                
            }
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();

        }
        return false;
    }

    @Override
    public Sinhvien getSinhVienById(int idSinhVien) {

        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Sinhvien> q = b.createQuery(Sinhvien.class);

        Root<Sinhvien> root = q.from(Sinhvien.class);
        q.select(root);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(root.get("idSinhVien"), idSinhVien));
        q.where(predicates.toArray(new Predicate[0]));
        Query query = s.createQuery(q);
        return (Sinhvien) query.getSingleResult();

    }

    @Override
    public boolean deleteSinhVien(int idSinhVien) {
        Session s = this.factory.getObject().getCurrentSession();
        Sinhvien sv = this.getSinhVienById(idSinhVien);
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Taikhoan> q = b.createQuery(Taikhoan.class);
        Root r = q.from(Taikhoan.class);
        q.select(r).where(b.equal(r.get("idTaiKhoan"), sv.getIdTaiKhoan().getIdTaiKhoan()));
        Query query = s.createQuery(q);
        Taikhoan tk = (Taikhoan) query.getSingleResult();
        try {
            s.remove(tk);
            s.remove(sv);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
