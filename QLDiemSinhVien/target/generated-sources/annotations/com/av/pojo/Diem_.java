package com.av.pojo;

import com.av.pojo.Monhoc;
import com.av.pojo.Sinhvien;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-08-27T03:16:10")
@StaticMetamodel(Diem.class)
public class Diem_ { 

    public static volatile SingularAttribute<Diem, Monhoc> idMonHoc;
    public static volatile SingularAttribute<Diem, Short> trangThai;
    public static volatile SingularAttribute<Diem, Integer> idDiem;
    public static volatile SingularAttribute<Diem, Sinhvien> idSinhVien;
    public static volatile SingularAttribute<Diem, Double> diemTrungBinh;
    public static volatile SingularAttribute<Diem, String> xepLoai;
    public static volatile SingularAttribute<Diem, Double> diemCuoiKy;
    public static volatile SingularAttribute<Diem, Double> diemGiuaKy;

}