package com.av.pojo;

import com.av.pojo.Diem;
import com.av.pojo.Lophoc;
import com.av.pojo.Taikhoan;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-09-07T16:29:57")
@StaticMetamodel(Sinhvien.class)
public class Sinhvien_ { 

    public static volatile SingularAttribute<Sinhvien, String> diaChi;
    public static volatile SingularAttribute<Sinhvien, String> soDienThoai;
    public static volatile SingularAttribute<Sinhvien, Lophoc> maLop;
    public static volatile SingularAttribute<Sinhvien, Integer> idSinhVien;
    public static volatile SingularAttribute<Sinhvien, Taikhoan> idTaiKhoan;
    public static volatile SingularAttribute<Sinhvien, Date> ngaySinh;
    public static volatile SingularAttribute<Sinhvien, String> hoTen;
    public static volatile SingularAttribute<Sinhvien, Short> gioiTinh;
    public static volatile SetAttribute<Sinhvien, Diem> diemSet;
    public static volatile SingularAttribute<Sinhvien, String> heDaoTao;
    public static volatile SingularAttribute<Sinhvien, String> email;

}