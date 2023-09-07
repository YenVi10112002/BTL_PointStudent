/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.repository.impl;

import com.av.pojo.Giangvien;
import com.av.pojo.Loaitaikhoan;
import com.av.pojo.Sinhvien;
import com.av.pojo.Taikhoan;
import com.av.repository.SinhVienRepository;
import com.av.repository.TaiKhoanRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class TaiKhoanRepositoryImpl implements TaiKhoanRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private BCryptPasswordEncoder passEncoder;
    
    @Autowired
    private SinhVienRepository svRepo;

    @Override
    public boolean updateImg(Taikhoan s) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            session.update(s);
            return true;

        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    // Sua
    @Override
    public Taikhoan getTaiKhoan(int idTaiKhoan) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Taikhoan> q = b.createQuery(Taikhoan.class);

        Root<Taikhoan> root = q.from(Taikhoan.class);
        q.select(root);
        q.where(b.equal(root.get("idTaiKhoan"), idTaiKhoan));
        Query query = session.createQuery(q);
        try {
            return (Taikhoan) query.getSingleResult();
        } catch (NoResultException | NonUniqueResultException ex) {

            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addAcount(Taikhoan t) {
        if (t.getXacNhanMk() == null || t.getTenTaiKhoan() == null || t.getMatKhau() == null) {
            return false;
        }
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Sinhvien> q = b.createQuery(Sinhvien.class);
        Root<Sinhvien> root = q.from(Sinhvien.class);
        q.select(root)
                .where(b.equal(root.get("email"), t.getTenTaiKhoan()));
        Query query = s.createQuery(q);
        try {
            Sinhvien p = (Sinhvien) query.getSingleResult();
            if (p.getIdTaiKhoan() == null && p.getEmail() != null) {
                s.save(t);
                p.setIdTaiKhoan(t);
                s.update(p);
                return true;
            }
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
            if (duplicateCount == 0) {
                if (t.getIdTaiKhoan() == null && gv != null) {
                    s.save(t);
                    gv.setIdTaiKhoan(t);

                }
                return true;
            } else {
                return false;
            }
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

    @Override
    public Loaitaikhoan getChucVu(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Loaitaikhoan where idloaitaikhoan=:id");
        q.setParameter("id", id);
        return (Loaitaikhoan) q.getSingleResult();
    }

    @Override
    public Taikhoan getUserByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Taikhoan Where tenTaiKhoan=:un");
        q.setParameter("un", username);
        return (Taikhoan) q.getSingleResult();
    }

    @Override
    public boolean authUser(String username, String password) {
        Taikhoan u = this.getUserByUsername(username);
        return this.passEncoder.matches(password, u.getMatKhau());
    }

    @Override
    public boolean addUser(Taikhoan u) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Sinhvien> q = b.createQuery(Sinhvien.class);
        Root<Sinhvien> root = q.from(Sinhvien.class);
        q.select(root)
                .where(b.equal(root.get("email"), u.getTenTaiKhoan()));

        Query query = s.createQuery(q);

        try {
            Sinhvien p = (Sinhvien) query.getSingleResult();

            if (p.getIdTaiKhoan() == null && p.getEmail() != null) {
                s.save(u);
                p.setIdTaiKhoan(u);
                s.update(p);
                return true;
            }

            return false;
        } catch (HibernateException ex) {
            return false;
        }
    }

    @Override
    public boolean kiemTraTaiKhoan(Taikhoan user) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Sinhvien> q = b.createQuery(Sinhvien.class);
        Root<Sinhvien> root = q.from(Sinhvien.class);
        q.select(root)
                .where(b.equal(root.get("email"), user.getTenTaiKhoan()));
        Query query = s.createQuery(q);
        List<Sinhvien> resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return false; // Truy vấn không trả về kết quả
        }
        try {
            Sinhvien p = (Sinhvien) query.getSingleResult();

            if (p.getIdTaiKhoan() == null && p.getEmail() != null) {
                return true;
            }

        } catch (HibernateException ex) {
            return false;

        }

        return false;
    }
    //Sua
    @Override
    public Taikhoan thayDoiMatKhau(Taikhoan a) {
        Session s = this.factory.getObject().getCurrentSession();
        if(a != null){
            s.update(a);
        }
        
        return a;
    }
    
    // update xoa 
//    @Override
//    public boolean deleteTaiKhoanBySinhVien(int idSinhVien) {
//        Session s = this.factory.getObject().getCurrentSession();
//        Taikhoan tk = this.getTaikhoanBySinhVien(idSinhVien);
//        try {
//            if(tk != null){
//                s.delete(tk);
//            }
//            return true;
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
    //update lay
//     @Override
//    public Taikhoan getTaikhoanBySinhVien(int idSinhVien) {
//        Session s = this.factory.getObject().getCurrentSession();
//        Sinhvien sv = this.svRepo.getSinhVienById(idSinhVien);
//        CriteriaBuilder b = s.getCriteriaBuilder();
//        CriteriaQuery<Taikhoan> q = b.createQuery(Taikhoan.class);
//        Root r = q.from(Taikhoan.class);
//        if (sv.getIdTaiKhoan() != null) {
//            q.select(r).where(b.equal(r.get("idTaiKhoan"), sv.getIdTaiKhoan().getIdTaiKhoan()));
//            Query query = s.createQuery(q);
//            return (Taikhoan) query.getSingleResult();
//        }else
//            return null;
//    }
    
    //update xoa 
    @Override
    public boolean deleteTK(Taikhoan tk) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            if (tk != null) {
                session.delete(tk);
                return true;
            }
            return false;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }

    }
}
