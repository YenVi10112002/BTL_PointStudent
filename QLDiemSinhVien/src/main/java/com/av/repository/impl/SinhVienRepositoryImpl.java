/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.repository.impl;

import com.av.pojo.Diem;
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
import org.springframework.context.annotation.PropertySource;

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

    

}
