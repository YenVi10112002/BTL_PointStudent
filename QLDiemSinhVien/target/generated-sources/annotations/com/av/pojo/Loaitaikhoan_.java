package com.av.pojo;

import com.av.pojo.Taikhoan;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-07-26T03:25:30")
@StaticMetamodel(Loaitaikhoan.class)
public class Loaitaikhoan_ { 

    public static volatile SingularAttribute<Loaitaikhoan, Integer> idloaitaikhoan;
    public static volatile SingularAttribute<Loaitaikhoan, String> tenloai;
    public static volatile SetAttribute<Loaitaikhoan, Taikhoan> taikhoanSet;

}