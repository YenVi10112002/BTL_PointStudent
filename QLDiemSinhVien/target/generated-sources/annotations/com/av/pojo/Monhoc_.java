package com.av.pojo;

import com.av.pojo.Diem;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-07-25T19:50:16")
@StaticMetamodel(Monhoc.class)
public class Monhoc_ { 

    public static volatile SingularAttribute<Monhoc, String> idGiangVien;
    public static volatile SingularAttribute<Monhoc, Integer> idMonHoc;
    public static volatile SingularAttribute<Monhoc, String> hinhThucThi;
    public static volatile SingularAttribute<Monhoc, String> tenMonHoc;
    public static volatile SingularAttribute<Monhoc, Integer> hocKy;
    public static volatile SingularAttribute<Monhoc, Integer> soTinChi;
    public static volatile SetAttribute<Monhoc, Diem> diemSet;
    public static volatile SingularAttribute<Monhoc, String> phongHoc;

}