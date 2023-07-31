package com.av.pojo;

import com.av.pojo.DiemPK;
import com.av.pojo.Monhoc;
import com.av.pojo.Sinhvien;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-07-31T14:32:32")
@StaticMetamodel(Diem.class)
public class Diem_ { 

    public static volatile SingularAttribute<Diem, Monhoc> monhoc;
    public static volatile SingularAttribute<Diem, DiemPK> diemPK;
    public static volatile SingularAttribute<Diem, Short> trangThai;
    public static volatile SingularAttribute<Diem, Sinhvien> sinhvien;
    public static volatile SingularAttribute<Diem, Double> diemTrungBinh;
    public static volatile SingularAttribute<Diem, String> xepLoai;
    public static volatile SingularAttribute<Diem, Double> diemCuoiKy;
    public static volatile SingularAttribute<Diem, Double> diemGiuaKy;

}