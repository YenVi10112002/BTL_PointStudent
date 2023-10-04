/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.repository.impl;

import com.av.pojo.Diem;
import com.av.pojo.DiemMonHoc;
import com.av.pojo.DiemMonHocComparator;
import com.av.pojo.Loaidiem;
import com.av.pojo.Monhoc;
import com.av.pojo.MonhocHocky;
import com.av.pojo.Monhocdangky;
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
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
    @Autowired
    private JavaMailSender emailSender;

    @Override
    public List<Object> getListDiemTrungBinh(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root<Diem> rDiem = q.from(Diem.class);
        Root<Monhocdangky> rMonhocDangKy = q.from(Monhocdangky.class);
        Root<MonhocHocky> rMonHocHocKy = q.from(MonhocHocky.class);
        List<Predicate> predicates = new ArrayList<>();
        String sinhvienId = params.get("SinhVienId");
        predicates.add(b.equal(rDiem.get("idMonHoc"), rMonhocDangKy.get("idMonHocDangKy")));
        predicates.add(b.equal(rMonhocDangKy.get("idSinhVien"), Integer.parseInt(sinhvienId)));
        predicates.add(b.equal(rDiem.get("tenDiem"), 6));
        predicates.add(b.equal(rMonHocHocKy.get("idMonHocHocKy"), rMonhocDangKy.get("idMonHoc")));
        Expression<Double> averageDiemTrungBinh = b.avg(rDiem.get("soDiem"));
        Expression<Double> averageDiemTrungBinh4 = b.prod(b.avg(rDiem.get("soDiem")), 0.4);
        q.multiselect(
                rMonHocHocKy.get("idHocky").get("tenHocKy"),
                averageDiemTrungBinh,
                averageDiemTrungBinh4
        )
                .where(predicates.toArray(new Predicate[0]));
//                .groupBy(rMonHocHocKy.get("idMonHocHocKy").get("idHocKY"));

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
        Root<Diem> rDiem = q.from(Diem.class);
        Root<Monhocdangky> rMonHocDangKy = q.from(Monhocdangky.class);
        String sinhvienId = params.get("SinhVienId");
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rDiem.get("idMonHoc"), rMonHocDangKy.get("idMonHocDangKy")));
        predicates.add(b.equal(rMonHocDangKy.get("idSinhVien"), Integer.parseInt(sinhvienId)));
        predicates.add(b.equal(rDiem.get("tenDiem"), 6));
        q.select(b.avg(rDiem.get("soDiem")))
                .where(predicates.toArray(Predicate[]::new));

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
        Root<Diem> rDiem = q.from(Diem.class);
        Root<Monhocdangky> rMonHocDangKy = q.from(Monhocdangky.class);
        String sinhvienId = params.get("SinhVienId");
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rDiem.get("idMonHoc"), rMonHocDangKy.get("idMonHocDangKy")));
        predicates.add(b.equal(rMonHocDangKy.get("idSinhVien"), Integer.parseInt(sinhvienId)));
        predicates.add(b.equal(rDiem.get("tenDiem"), 6));
        q.select(b.avg(rDiem.get("soDiem")))
                .where(predicates.toArray(Predicate[]::new));

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
//

    @Override
    public List<DiemMonHoc> getListDiemDangHoc(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Diem> q = b.createQuery(Diem.class);
        Root<Diem> rDiem = q.from(Diem.class);
        Root<Monhocdangky> rMonHocDangKy = q.from(Monhocdangky.class);
        String sinhvienId = params.get("SinhVienId");
        List<Monhocdangky> monHocList = this.getListMonHocDangKy(params);
        List<DiemMonHoc> monHocDiemList = new ArrayList<>();

        for (Monhocdangky monHoc : monHocList) {
            if (monHoc.getKhoaMon() == 0) {
                DiemMonHoc monHocDiem = new DiemMonHoc(monHoc);
                // Lấy danh sách điểm cho môn học cụ thể
                List<Diem> diemList = this.getListDiemByIdMonHocDangKy(monHoc.getIdMonHocDangKy());
                // Thêm điểm vào danh sách MonHocDiem
                for (Diem diem : diemList) {
                    monHocDiem.addDiem(diem); // Diem.getDiem() là phương thức lấy giá trị điểm
                }
                // Thêm MonHocDiem vào danh sách chung
                monHocDiemList.add(monHocDiem);
            }
        }
        try {
            Collections.sort(monHocDiemList, new DiemMonHocComparator());
            return monHocDiemList;
        } catch (NoResultException | NonUniqueResultException ex) {

            ex.printStackTrace();
            return Collections.emptyList();
        }

    }
    
     @Override
    public List<DiemMonHoc> getListDiemDaHoc(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Diem> q = b.createQuery(Diem.class);
        List<Monhocdangky> monHocList = this.getListMonHocDangKy(params);
        List<DiemMonHoc> monHocDiemList = new ArrayList<>();

        for (Monhocdangky monHoc : monHocList) {
            if (monHoc.getKhoaMon() == 1) {
                DiemMonHoc monHocDiem = new DiemMonHoc(monHoc);
                // Lấy danh sách điểm cho môn học cụ thể
                List<Diem> diemList = this.getListDiemByIdMonHocDangKy(monHoc.getIdMonHocDangKy());
                // Thêm điểm vào danh sách MonHocDiem
                for (Diem diem : diemList) {
                    monHocDiem.addDiem(diem); // Diem.getDiem() là phương thức lấy giá trị điểm
                }
                // Thêm MonHocDiem vào danh sách chung
                monHocDiemList.add(monHocDiem);
            }

        }
        try {
            Collections.sort(monHocDiemList, new DiemMonHocComparator());
            return monHocDiemList;
        } catch (NoResultException | NonUniqueResultException ex) {

            ex.printStackTrace();
            return Collections.emptyList();
        }

    }
//

    @Override
    public Diem addDiem(Monhocdangky monhoc, List<Diem> diem, DiemMonHoc diemMonHoc) {
        Session session = this.factory.getObject().getCurrentSession();

        Loaidiem loaiDiemKt1 = this.getLoaiDiemKT1();
        Loaidiem loaiDiemKt2 = this.getLoaiDiemKT2();
        Loaidiem loaiDiemKt3 = this.getLoaiDiemKT3();
        short khoaDiem = 0;
        List<Diem> diemToBeDeleted = new ArrayList<>();
        for (Diem diemm : diem) {
            if (diemm.getTenDiem().getIdLoaiDiem() == 3 || diemm.getTenDiem().getIdLoaiDiem() == 4 || diemm.getTenDiem().getIdLoaiDiem() == 5) {
                diemToBeDeleted.add(diemm);
            }
        }
        for (Diem diemm : diemToBeDeleted) {
            session.delete(diemm);
            diem.remove(diemm);
        }

        if (diemMonHoc.getDiemKT2() == -1) {

            Diem diemTk1 = new Diem();
            diemTk1.setIdMonHoc(monhoc);
            diemTk1.setTenDiem(loaiDiemKt1);
            diemTk1.setSoDiem(diemMonHoc.getDiemKT1());
            diemTk1.setKhoaDiem(khoaDiem);
            session.save(diemTk1);

        } else if (diemMonHoc.getDiemKT3() == -1) {

            Diem diemTk1 = new Diem();
            diemTk1.setIdMonHoc(monhoc);
            diemTk1.setTenDiem(loaiDiemKt1);
            diemTk1.setSoDiem(diemMonHoc.getDiemKT1());
            diemTk1.setKhoaDiem(khoaDiem);
            session.save(diemTk1);

            Diem diemTk2 = new Diem();
            diemTk2.setIdMonHoc(monhoc);
            diemTk2.setTenDiem(loaiDiemKt2);
            diemTk2.setSoDiem(diemMonHoc.getDiemKT2());
            diemTk2.setKhoaDiem(khoaDiem);
            session.save(diemTk2);

        } else if (diemMonHoc.getDiemKT3() != -1) {

            Diem diemTk1 = new Diem();
            diemTk1.setIdMonHoc(monhoc);
            diemTk1.setTenDiem(loaiDiemKt1);
            diemTk1.setSoDiem(diemMonHoc.getDiemKT1());
            diemTk1.setKhoaDiem(khoaDiem);
            session.save(diemTk1);

            Diem diemTk2 = new Diem();
            diemTk2.setIdMonHoc(monhoc);
            diemTk2.setTenDiem(loaiDiemKt2);
            diemTk2.setSoDiem(diemMonHoc.getDiemKT2());
            diemTk2.setKhoaDiem(khoaDiem);
            session.save(diemTk2);

            Diem diemTk3 = new Diem();
            diemTk3.setIdMonHoc(monhoc);
            diemTk3.setTenDiem(loaiDiemKt3);
            diemTk3.setSoDiem(diemMonHoc.getDiemKT3());
            diemTk3.setKhoaDiem(khoaDiem);
            session.save(diemTk3);

        }
        session.update(monhoc);
        for (Diem diemm : diem) {
            session.update(diemm);
        }

        return null;
    }
//

    @Override
    public Monhocdangky getDiemByIdMonHoc(int idMonHoc, int idSinhVien) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root<Monhocdangky> rDiem = q.from(Monhocdangky.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rDiem.get("idSinhVien"), idSinhVien));
        predicates.add(b.equal(rDiem.get("idMonHoc"), idMonHoc));
        q.select(b.array(rDiem))
                .where(predicates.toArray(Predicate[]::new));
        Query query = session.createQuery(q);
        return (Monhocdangky) query.getSingleResult();
    }

    @Override
    public List<Diem> setDiemByCSV(Map<String, String> params) {
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

//    // lay diem theo sinh vien
//    @Override
//    public List<Diem> getDiemBySinhVien(int idSinhVien) {
//        Session s = this.factory.getObject().getCurrentSession();
//        CriteriaBuilder b = s.getCriteriaBuilder();
//        CriteriaQuery<Diem[]> q = b.createQuery(Diem[].class);
//
//        Root r = q.from(Diem.class);
//        q.select(r);
//        q.where(b.equal(r.get("idSinhVien").get("idSinhVien"), idSinhVien));
//        Query query = s.createQuery(q);
//        return query.getResultList();
//    }
//
//    // xoa diem theo sinh vien
//    @Override
//    public boolean deleteDiemBySinhVien(int idSinhVien) {
//        Session s = this.factory.getObject().getCurrentSession();
//        List<Diem> diems = this.getDiemBySinhVien(idSinhVien);
//        try {
//            for (Diem diem : diems) {
//                s.delete(diem);
//            }
//            return true;
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
    @Override
    public Monhocdangky getMonHocDangKyById(int idDiem) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Monhocdangky> q = b.createQuery(Monhocdangky.class);
        Root<Monhocdangky> rDiem = q.from(Monhocdangky.class);
        q.select(rDiem)
                .where(b.equal(rDiem.get("idMonHocDangKy"), idDiem));
        Query query = session.createQuery(q);
        return (Monhocdangky) query.getSingleResult();
    }

    @Override
    public List<Monhocdangky> getDiemByidGiangVien(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rSinhVien = q.from(Sinhvien.class);
        Root rDiem = q.from(Monhocdangky.class);
        Root rMonHoc = q.from(MonhocHocky.class);
        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String giangVien = params.get("idGiangVien");
            if (giangVien != null) {
                predicates.add(b.equal(rMonHoc.get("idGiangVien"), Integer.parseInt(giangVien)));
                predicates.add(b.equal(rDiem.get("idMonHoc"), rMonHoc.get("idMonHocHocKy")));
            }
            String tenSinhVien = params.get("tenSinhVien");
            if (tenSinhVien != null) {
                try {
                    int parsedIdSinhVien = Integer.parseInt(tenSinhVien);
                    predicates.add(b.equal(rDiem.get("idSinhVien"), parsedIdSinhVien));
                } catch (NumberFormatException e) {

                    predicates.add(b.equal(rDiem.get("idSinhVien"), rSinhVien.get("idSinhVien")));
                    predicates.add(b.like(rSinhVien.get("hoTen"), String.format("%%%s%%", tenSinhVien)));
                }
            }

            q.groupBy(rDiem.get("idMonHocDangKy"));
            q.select(rDiem).where(predicates.toArray(new Predicate[0]));
            Query query = s.createQuery(q);
            return query.getResultList();
        }
        return null;
    }

    @Override
    public boolean khoaDiem(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Monhocdangky[]> q = b.createQuery(Monhocdangky[].class);
        Root rDiem = q.from(Monhocdangky.class);
        if (params != null) {
            String idMonHoc = params.get("idMonHoc");
            q.select(rDiem).where(b.equal(rDiem.get("idMonHoc"), Integer.parseInt(idMonHoc)));
            Query query = s.createQuery(q);
            List<Monhocdangky> DiemSV = query.getResultList();
            SimpleMailMessage message = new SimpleMailMessage();
            short khoaDiem = 1;
            for (Monhocdangky monhoc : DiemSV) {
                List<Diem> diemList = this.getListDiemByIdMonHocDangKy(monhoc.getIdMonHocDangKy());
                // Thêm điểm vào danh sách MonHocDiem
                for (Diem diem : diemList) {
                    // Diem.getDiem() là phương thức lấy giá trị điểm
                    diem.setKhoaDiem(khoaDiem);
                    s.update(diem);
                }
                monhoc.setKhoaMon(khoaDiem);
                message.setTo(monhoc.getIdSinhVien().getEmail().toString());
                message.setSubject("Thong bao diem");
                message.setText("Diem cua mon " + monhoc.getIdMonHoc().getIdMonHoc().getTenMonHoc().toString() + " co ma mon " + monhoc.getIdMonHoc().getIdMonHoc().toString() + " Đã có");
                emailSender.send(message);
            }
            return true;
        }
        return false;
    }

//    @Override
//    public boolean deleteDiem(int idMonHoc, int idSinhVien) {
//        Session s = this.factory.getObject().getCurrentSession();
//        Diem d = this.getDiemByIdMonHoc(idMonHoc, idSinhVien);
//        try {
//            if(d != null)
//                s.delete(d);
//            return true;
//        } catch (HibernateException e) {
//            return false;
//        }
//    }
    @Override
    public List<Diem> getListDiemByIdMonHocDangKy(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root<Diem> rDiem = q.from(Diem.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rDiem.get("idMonHoc").get("idMonHocDangKy"), id));
        q.select(b.array(rDiem))
                .where(predicates.toArray(Predicate[]::new));
        Query query = session.createQuery(q);
        try {
            return query.getResultList();
        } catch (NoResultException | NonUniqueResultException ex) {

            ex.printStackTrace();
            return Collections.emptyList();
        }

    }

    @Override
    public List<Monhocdangky> getListMonHocDangKy(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Monhocdangky[]> q = b.createQuery(Monhocdangky[].class);
        String sinhvienId = params.get("SinhVienId");
        Root rDiem = q.from(Monhocdangky.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rDiem.get("idSinhVien"), Integer.parseInt(sinhvienId)));
        q.select(rDiem)
                .where(predicates.toArray(Predicate[]::new));
        Query query = session.createQuery(q);
        try {
            return query.getResultList();
        } catch (NoResultException | NonUniqueResultException ex) {

            ex.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Loaidiem getLoaiDiemKT1() {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Loaidiem[]> q = b.createQuery(Loaidiem[].class);
        Root rDiem = q.from(Loaidiem.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rDiem.get("idLoaiDiem"), 3));
        q.select(rDiem)
                .where(predicates.toArray(Predicate[]::new));
        Query query = session.createQuery(q);
        try {
            return (Loaidiem) query.getSingleResult();
        } catch (NoResultException | NonUniqueResultException ex) {

            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Loaidiem getLoaiDiemKT2() {

        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Loaidiem[]> q = b.createQuery(Loaidiem[].class);
        Root rDiem = q.from(Loaidiem.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rDiem.get("idLoaiDiem"), 4));
        q.select(rDiem)
                .where(predicates.toArray(Predicate[]::new));
        Query query = session.createQuery(q);
        try {
            return (Loaidiem) query.getSingleResult();
        } catch (NoResultException | NonUniqueResultException ex) {

            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Loaidiem getLoaiDiemKT3() {

        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Loaidiem[]> q = b.createQuery(Loaidiem[].class);
        Root rDiem = q.from(Loaidiem.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rDiem.get("idLoaiDiem"), 5));
        q.select(rDiem)
                .where(predicates.toArray(Predicate[]::new));
        Query query = session.createQuery(q);
        try {
            return (Loaidiem) query.getSingleResult();
        } catch (NoResultException | NonUniqueResultException ex) {

            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public DiemMonHoc getDiemMonHocByIdDiem(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();

        Monhocdangky monhoc = this.getMonHocDangKyById(id);
        DiemMonHoc monHocDiem = new DiemMonHoc(monhoc);
        // Lấy danh sách điểm cho môn học cụ thể
        List<Diem> diemList = this.getListDiemByIdMonHocDangKy(monhoc.getIdMonHocDangKy());
        // Thêm điểm vào danh sách MonHocDiem
        for (Diem diem : diemList) {
            monHocDiem.addDiem(diem); // Diem.getDiem() là phương thức lấy giá trị điểm
        }

        return monHocDiem;
    }

   
}
