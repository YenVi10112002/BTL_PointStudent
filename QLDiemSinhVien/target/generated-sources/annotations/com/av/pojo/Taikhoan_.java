package com.av.pojo;

import com.av.pojo.Giangvien;
import com.av.pojo.Giaovu;
import com.av.pojo.Sinhvien;
import com.av.pojo.Traloidiendan;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-08-27T03:16:10")
=======
@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-08-26T16:18:30")
>>>>>>> 7a6501278db722a7e7531bea51022dd1df282994
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
    public static volatile SingularAttribute<Taikhoan, String> chucVu;

}