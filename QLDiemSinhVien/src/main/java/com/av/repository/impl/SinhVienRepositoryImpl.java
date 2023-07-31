/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.repository.impl;

import com.av.pojo.Diem;
import com.av.pojo.Sinhvien;
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
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
    public List<Sinhvien> getSinhVien(int idTaiKhoan) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Sinhvien> q = b.createQuery(Sinhvien.class);
        
        Root root = q.from(Sinhvien.class);
        q.select(root);
        List<Predicate> predicates = new ArrayList<>();
        
        predicates.add(b.equal(root.get("idTaiKhoan"), idTaiKhoan));
        q.where(predicates.toArray(Predicate[]::new));
        Query query = session.createQuery(q);
        return query.getResultList();
//        try {
//            Sinhvien sinhvien = (Sinhvien) q.getSingleResult();
//            return sinhvien;
//        } catch (NoResultException e) {
//            return null; // Không tìm thấy sinh viên với ID tương ứng
//        } catch (NonUniqueResultException e) {
//            // Xử lý nếu có nhiều hơn một kết quả trả về (nếu ID không duy nhất)
//            return null;
//        }
    }

    @Override
    public int getHocKy() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT MAX(hocKy) FROM Monhoc");
        Integer maxValue = (Integer) q.getSingleResult();
        return maxValue;
    }

    


    @Override
    public List<Traloidiendan> getTraLoi(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Traloidiendan> q = b.createQuery(Traloidiendan.class);
        Root root = q.from(Traloidiendan.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String cateId = params.get("cauhoiId");
            if (cateId != null) {
                predicates.add(b.equal(root.get("idCauHoiDienDan"), Integer.parseInt(cateId)));
            }
            q.where(predicates.toArray(Predicate[]::new));
        }
        q.orderBy(b.desc(root.get("idTraLoiDienDan")));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

}
