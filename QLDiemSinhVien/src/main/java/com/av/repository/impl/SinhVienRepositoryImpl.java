/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.repository.impl;

import com.av.pojo.Diem;
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
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

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
    @Override
    public int getHocKy() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT MAX(hocKy) FROM Monhoc");
        Integer maxValue = (Integer) q.getSingleResult();
        return maxValue;
    }

    @Override
    public double getDiemTrungBinh(int sinhvienId) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT AVG(diemTrungBinh) FROM Diem Where idSinhVien = :sinhvienId");
        q.setParameter("sinhvienId", sinhvienId);
        DecimalFormat decimalFormat = new DecimalFormat("#.#",  new DecimalFormatSymbols(Locale.US));
        try {
            Double averageValue = (Double) q.getSingleResult();
            if (averageValue != null) {
                averageValue = Double.valueOf(decimalFormat.format(averageValue));
            } else {
                averageValue = 0.0;
            }
            return averageValue;
        } catch (NoResultException e) {
            return 0.0; // Không tìm thấy sinh viên với ID tương ứng
        } catch (NonUniqueResultException e) {
            // Xử lý nếu có nhiều hơn một kết quả trả về (nếu ID không duy nhất)
            return 0.0;
        }

    }

    @Override
    public List<Diem> DiemByMonHoc() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Diem");
        return q.getResultList();
    }
    
    
}
