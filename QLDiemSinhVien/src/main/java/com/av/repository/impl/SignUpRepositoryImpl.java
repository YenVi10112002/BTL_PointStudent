/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.repository.impl;

import com.av.pojo.Giangvien;
import com.av.pojo.Sinhvien;
import com.av.pojo.Taikhoan;
import com.av.repository.SignUpRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
public class SignUpRepositoryImpl implements SignUpRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public boolean addAcount(Taikhoan t) {
        Session s = this.factory.getObject().getCurrentSession();

        try {
            if (t.getIdTaiKhoan() == null) {
                s.save(t);
            }
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());

        }
        return false;

    }

    @Override
    public boolean addAcountGV(Taikhoan t) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        
        // Kiểm tra xem tên tài khoản có bị trùng không
        CriteriaQuery<Long> countQuery = b.createQuery(Long.class);
        Root<Taikhoan> countRoot = countQuery.from(Taikhoan.class);
        countQuery.select(b.count(countRoot)).where(b.equal(countRoot.get("tenTaiKhoan"), t.getTenTaiKhoan()));
        long duplicateCount = s.createQuery(countQuery).uniqueResult();
        
        //Lưu id tài khoản vào khóa ngoại của giảng viên 
        CriteriaQuery<Giangvien> q = b.createQuery(Giangvien.class);
        Root<Giangvien> root = q.from(Giangvien.class);
        q.select(root).where(b.equal(root.get("idGiangVien"), t.getGiangvien1().getIdGiangVien()));
        Query query = s.createQuery(q);
        Giangvien gv = (Giangvien) query.getSingleResult();
        
        try {
            if (t.getIdTaiKhoan() == null && gv != null && duplicateCount == 0) {
                s.save(t);
                gv.setIdTaiKhoan(t);
                return true;
            }else
                return false;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
            return false;
        }

    }

    @Override
    public List<Taikhoan> getTaiKhoan() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Taikhoan");
        return q.getResultList();
    }

}
