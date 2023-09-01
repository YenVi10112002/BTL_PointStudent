/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.repository.impl;

import com.av.pojo.Diem;
import com.av.pojo.Monhoc;
import com.av.pojo.Sinhvien;
import com.av.repository.DiemRepository;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.Locale;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class DiemRepositoryImpl implements DiemRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public double getDiemTrungBinh(int sinhvienId) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Double> q = b.createQuery(Double.class);
        Root<Diem> root = q.from(Diem.class);
        q.select(b.avg(root.get("diemTrungBình")))
                .where(b.equal(root.get("idSinhVien"), sinhvienId));
        Query query = s.createQuery(q);

        DecimalFormat decimalFormat = new DecimalFormat("#.#", new DecimalFormatSymbols(Locale.US));
        try {
            Double averageValue = (Double) query.getSingleResult();
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
    public double getDiemTrungBinhHe(int sinhvienId) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Double> q = b.createQuery(Double.class);
        Root<Diem> root = q.from(Diem.class);
        q.select(b.avg(root.get("diemTrungBình")))
                .where(b.equal(root.get("idSinhVien"), sinhvienId));
        Query query = s.createQuery(q);
        DecimalFormat decimalFormat = new DecimalFormat("#.#", new DecimalFormatSymbols(Locale.US));
        try {
            Double averageValue = (Double) query.getSingleResult();
            if (averageValue != null) {
                averageValue = averageValue * 0.4;
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
    public List<Object> getListDiem(int sinhvienId) {

        Session session = this.factory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root<Diem> rDiem = q.from(Diem.class);
        Root<Monhoc> rMonhoc = q.from(Monhoc.class);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.equal(rDiem.get("idSinhVien"), sinhvienId));
        predicates.add(b.equal(rDiem.get("idMonHoc"), rMonhoc.get("idMonHoc")));

        q.select(b.array(rDiem.get("diemTrungBình"), rDiem.get("diemCuoiKy"), rDiem.get("diemGiuaKy"), rDiem.get("trangThai"), rMonhoc.get("diemTrungBình"), rMonhoc.get("hocKy"), b.prod(rDiem.get("diemTrungBinh"), 0.4)))
                .where(predicates.toArray(Predicate[]::new));

        q.orderBy(b.asc(rMonhoc.get("hocKy")));
        Query query = session.createQuery(q);

        try {
            return query.getResultList();
        } catch (NoResultException | NonUniqueResultException ex) {

            ex.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public List<Object> getListDiemTrungBinh(int sinhvienId) {

        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root<Diem> rDiem = q.from(Diem.class);
        Root<Monhoc> rMonhoc = q.from(Monhoc.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rDiem.get("idSinhVien"), sinhvienId));
        predicates.add(b.equal(rDiem.get("idMonHoc"), rMonhoc.get("idMonHoc")));

        Expression<Double> averageDiemTrungBinh = b.avg(rDiem.get("diemTrungBình"));
        Expression<Double> averageDiemTrungBinh4 = b.prod(b.avg(rDiem.get("diemTrungBình")), 0.4);

        q.multiselect(
                rMonhoc.get("hocKy"),
                averageDiemTrungBinh,
                averageDiemTrungBinh4
        )
                .where(predicates.toArray(new Predicate[0]))
                .groupBy(rMonhoc.get("hocKy"));

        Query query = session.createQuery(q);

        try {
            return query.getResultList();
        } catch (NoResultException | NonUniqueResultException ex) {
            ex.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public List<Object> getListDiemTrungBinh2(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root<Diem> rDiem = q.from(Diem.class);
        Root<Monhoc> rMonhoc = q.from(Monhoc.class);
        List<Predicate> predicates = new ArrayList<>();
        String sinhvienId = params.get("SinhVienId");
        predicates.add(b.equal(rDiem.get("idSinhVien"), Integer.parseInt(sinhvienId)));
        predicates.add(b.equal(rDiem.get("idMonHoc"), rMonhoc.get("idMonHoc")));

        Expression<Double> averageDiemTrungBinh = b.avg(rDiem.get("diemTrungBình"));
        Expression<Double> averageDiemTrungBinh4 = b.prod(b.avg(rDiem.get("diemTrungBình")), 0.4);
        q.multiselect(
                rMonhoc.get("hocKy"),
                averageDiemTrungBinh,
                averageDiemTrungBinh4
        )
                .where(predicates.toArray(new Predicate[0]))
                .groupBy(rMonhoc.get("hocKy"));

        Query query = session.createQuery(q);

        try {
            return query.getResultList();
        } catch (NoResultException | NonUniqueResultException ex) {
            ex.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public double getDiemTrungBinh2(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Double> q = b.createQuery(Double.class);
        Root<Diem> root = q.from(Diem.class);
        String sinhvienId = params.get("SinhVienId");
        q.select(b.avg(root.get("diemTrungBình")))
                .where(b.equal(root.get("idSinhVien"), Integer.parseInt(sinhvienId)));
        Query query = s.createQuery(q);

        DecimalFormat decimalFormat = new DecimalFormat("#.#", new DecimalFormatSymbols(Locale.US));
        try {
            Double averageValue = (Double) query.getSingleResult();
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
    public double getDiemTrungBinhHe4(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Double> q = b.createQuery(Double.class);
        Root<Diem> root = q.from(Diem.class);
        String sinhvienId = params.get("SinhVienId");
        q.select(b.avg(root.get("diemTrungBình")))
                .where(b.equal(root.get("idSinhVien"), Integer.parseInt(sinhvienId)));
        Query query = s.createQuery(q);
        DecimalFormat decimalFormat = new DecimalFormat("#.#", new DecimalFormatSymbols(Locale.US));
        try {
            Double averageValue = (Double) query.getSingleResult();
            if (averageValue != null) {
                averageValue = averageValue * 0.4;
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
    public List<Object> getListDiem2(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root<Diem> rDiem = q.from(Diem.class);
        Root<Monhoc> rMonhoc = q.from(Monhoc.class);
        String sinhvienId = params.get("SinhVienId");
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.equal(rDiem.get("idSinhVien"), Integer.parseInt(sinhvienId)));
        predicates.add(b.equal(rDiem.get("idMonHoc"), rMonhoc.get("idMonHoc")));

        q.select(b.array(rDiem.get("diemTrungBình"), rDiem.get("diemCuoiKy"), rDiem.get("diemGiuaKy"), rDiem.get("trangThai"), rMonhoc.get("tenMonHoc"), rMonhoc.get("hocKy"), b.prod(rDiem.get("diemTrungBình"), 0.4)))
                .where(predicates.toArray(Predicate[]::new));

        q.orderBy(b.asc(rMonhoc.get("hocKy")));
        Query query = session.createQuery(q);

        try {
            return query.getResultList();
        } catch (NoResultException | NonUniqueResultException ex) {

            ex.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Diem addDiem(Diem diem) {
        Session session = this.factory.getObject().getCurrentSession();

        session.update(diem);

        return diem;
    }

    @Override
    public List<Diem> getDiemByIdMonHoc(int idMonHoc, int idSinhVien) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root<Diem> rDiem = q.from(Diem.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rDiem.get("idSinhVien"), idSinhVien));
        predicates.add(b.equal(rDiem.get("idMonHoc"), idMonHoc));
        q.select(b.array(rDiem))
                .where(predicates.toArray(Predicate[]::new));
        Query query = session.createQuery(q);
        return (List<Diem>) query.getResultList();
    }
    @Override
    public List<Diem> getDiemByCSV(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        String idMonHoc = params.get("idMonHoc");
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Diem> q = b.createQuery(Diem.class);
        Root<Diem> rDiem = q.from(Diem.class);
        
        q.select(rDiem)
                .where(b.equal(rDiem.get("idMonHoc"), Integer.parseInt(idMonHoc)));
        Query query = session.createQuery(q);
        return (List<Diem>) query.getResultList();
    }

}
