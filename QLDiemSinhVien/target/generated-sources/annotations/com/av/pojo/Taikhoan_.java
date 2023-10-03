package com.av.pojo;

import com.av.pojo.Cauhoidiendang;
import com.av.pojo.Giangvien;
import com.av.pojo.Giaovu;
import com.av.pojo.Loaitaikhoan;
import com.av.pojo.Sinhvien;
import com.av.pojo.Traloidiendan;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-09-28T11:19:38")
=======
@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-10-02T01:23:50")
>>>>>>> d25f930757f7259ce4c3fd2bf99e12079d727004
@StaticMetamodel(Taikhoan.class)
public class Taikhoan_ { 

    public static volatile SingularAttribute<Taikhoan, String> tenTaiKhoan;
    public static volatile SingularAttribute<Taikhoan, String> image;
    public static volatile SingularAttribute<Taikhoan, String> matKhau;
    public static volatile SetAttribute<Taikhoan, Traloidiendan> traloidiendanSet;
    public static volatile SingularAttribute<Taikhoan, Integer> idTaiKhoan;
    public static volatile SingularAttribute<Taikhoan, Giaovu> giaovu;
    public static volatile SingularAttribute<Taikhoan, Sinhvien> sinhvien;
    public static volatile SingularAttribute<Taikhoan, Giangvien> giangvien;
    public static volatile SingularAttribute<Taikhoan, Loaitaikhoan> chucVu;
    public static volatile SetAttribute<Taikhoan, Cauhoidiendang> cauhoidiendangSet;

}