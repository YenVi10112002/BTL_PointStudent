package com.av.pojo;

import com.av.pojo.Hedaotao;
import com.av.pojo.Hocky;
import com.av.pojo.Khoa;
import com.av.pojo.Nganhdaotao;
import com.av.pojo.Sinhvien;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-09-28T11:19:38")
=======
@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-10-02T01:23:50")
>>>>>>> d25f930757f7259ce4c3fd2bf99e12079d727004
@StaticMetamodel(Lophoc.class)
public class Lophoc_ { 

    public static volatile SingularAttribute<Lophoc, Hedaotao> idHeDaoTao;
    public static volatile SingularAttribute<Lophoc, Integer> idLopHoc;
    public static volatile SetAttribute<Lophoc, Hocky> hockySet;
    public static volatile SingularAttribute<Lophoc, Khoa> idKhoaHoc;
    public static volatile SingularAttribute<Lophoc, Nganhdaotao> idNganh;
    public static volatile SingularAttribute<Lophoc, String> tenLopHoc;
    public static volatile SetAttribute<Lophoc, Sinhvien> sinhvienSet;

}