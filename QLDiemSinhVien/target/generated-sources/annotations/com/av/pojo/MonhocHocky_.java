package com.av.pojo;

import com.av.pojo.Giangvien;
import com.av.pojo.Hocky;
import com.av.pojo.Monhoc;
import com.av.pojo.Monhocdangky;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-09-28T11:19:39")
@StaticMetamodel(MonhocHocky.class)
public class MonhocHocky_ { 

    public static volatile SingularAttribute<MonhocHocky, Giangvien> idGiangVien;
    public static volatile SingularAttribute<MonhocHocky, Integer> idMonHocHocKy;
    public static volatile SingularAttribute<MonhocHocky, Hocky> idHocky;
    public static volatile SingularAttribute<MonhocHocky, Date> ngayBatDau;
    public static volatile SingularAttribute<MonhocHocky, Monhoc> idMonHoc;
    public static volatile SetAttribute<MonhocHocky, Monhocdangky> monhocdangkySet;
    public static volatile SingularAttribute<MonhocHocky, Integer> phongHoc;
    public static volatile SingularAttribute<MonhocHocky, Integer> soLuong;
    public static volatile SingularAttribute<MonhocHocky, Date> ngayKetThuc;

}