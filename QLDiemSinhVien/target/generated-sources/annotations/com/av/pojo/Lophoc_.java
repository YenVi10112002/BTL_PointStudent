package com.av.pojo;

import com.av.pojo.Sinhvien;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-09-09T17:49:11")
@StaticMetamodel(Lophoc.class)
public class Lophoc_ { 

    public static volatile SingularAttribute<Lophoc, Integer> idLopHoc;
    public static volatile SingularAttribute<Lophoc, String> khoaHoc;
    public static volatile SingularAttribute<Lophoc, String> tenLopHoc;
    public static volatile SetAttribute<Lophoc, Sinhvien> sinhvienSet;

}