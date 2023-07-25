/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.repository.impl;

import com.av.pojo.Sinhvien;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.av.repository.SinhVienRepository;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class SinhVienRepositoryImpl implements SinhVienRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public Sinhvien getSinhVien(int sinhvienId) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Sinhvien WHERE idSinhVien = :sinhvienId");
        q.setParameter("sinhvienId", sinhvienId);

        try {
            Sinhvien sinhvien = (Sinhvien) q.getSingleResult();
            return sinhvien;
        } catch (NoResultException e) {
            return null; // Không tìm thấy sinh viên với ID tương ứng
        } catch (NonUniqueResultException e) {
            // Xử lý nếu có nhiều hơn một kết quả trả về (nếu ID không duy nhất)
            return null;
        }
    }
}
