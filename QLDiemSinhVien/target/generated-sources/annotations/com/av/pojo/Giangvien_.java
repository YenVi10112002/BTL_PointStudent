package com.av.pojo;

import com.av.pojo.Monhoc;
import com.av.pojo.Taikhoan;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-09-09T17:49:11")
@StaticMetamodel(Giangvien.class)
public class Giangvien_ { 

    public static volatile SingularAttribute<Giangvien, Integer> idGiangVien;
    public static volatile SingularAttribute<Giangvien, String> diaChi;
    public static volatile SingularAttribute<Giangvien, String> soDienThoai;
    public static volatile SingularAttribute<Giangvien, Taikhoan> idTaiKhoan;
    public static volatile SetAttribute<Giangvien, Monhoc> monhocSet;
    public static volatile SingularAttribute<Giangvien, Date> ngaySinh;
    public static volatile SingularAttribute<Giangvien, String> hoTen;
    public static volatile SingularAttribute<Giangvien, Short> gioiTinh;
    public static volatile SingularAttribute<Giangvien, String> email;

}