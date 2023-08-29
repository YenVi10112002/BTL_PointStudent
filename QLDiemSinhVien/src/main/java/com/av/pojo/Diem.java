/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FPTSHOP
 */
@Entity
@Table(name = "diem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diem.findAll", query = "SELECT d FROM Diem d"),
    @NamedQuery(name = "Diem.findByIdDiem", query = "SELECT d FROM Diem d WHERE d.idDiem = :idDiem"),
    @NamedQuery(name = "Diem.findByXepLoai", query = "SELECT d FROM Diem d WHERE d.xepLoai = :xepLoai"),
    @NamedQuery(name = "Diem.findByTrangThai", query = "SELECT d FROM Diem d WHERE d.trangThai = :trangThai"),
    @NamedQuery(name = "Diem.findByDiemGiuaKy", query = "SELECT d FROM Diem d WHERE d.diemGiuaKy = :diemGiuaKy"),
    @NamedQuery(name = "Diem.findByDiemCuoiKy", query = "SELECT d FROM Diem d WHERE d.diemCuoiKy = :diemCuoiKy"),
    @NamedQuery(name = "Diem.findByDiemKT1", query = "SELECT d FROM Diem d WHERE d.diemKT1 = :diemKT1"),
    @NamedQuery(name = "Diem.findByDiemTK2", query = "SELECT d FROM Diem d WHERE d.diemTK2 = :diemTK2"),
    @NamedQuery(name = "Diem.findByDiemTK3", query = "SELECT d FROM Diem d WHERE d.diemTK3 = :diemTK3"),
    @NamedQuery(name = "Diem.findByDiemTrungB\u00ecnh", query = "SELECT d FROM Diem d WHERE d.diemTrungB\u00ecnh = :diemTrungB\u00ecnh")})
public class Diem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDiem")
    private Integer idDiem;
    @Size(max = 20)
    @Column(name = "xepLoai")
    private String xepLoai;
    @Column(name = "trangThai")
    private Short trangThai;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "diemGiuaKy")
    private Double diemGiuaKy;
    @Column(name = "diemCuoiKy")
    private Double diemCuoiKy;
    @Column(name = "DiemKT1")
    private Double diemKT1;
    @Column(name = "DiemTK2")
    private Double diemTK2;
    @Column(name = "DiemTK3")
    private Double diemTK3;
    @Column(name = "diemTrungB\u00ecnh")
    private Double diemTrungBình;
    @JoinColumn(name = "idMonHoc", referencedColumnName = "idMonHoc")
    @ManyToOne
    private Monhoc idMonHoc;
    @JoinColumn(name = "idSinhVien", referencedColumnName = "idSinhVien")
    @ManyToOne
    private Sinhvien idSinhVien;

    public Diem() {
    }

    public Diem(Integer idDiem) {
        this.idDiem = idDiem;
    }

    public Integer getIdDiem() {
        return idDiem;
    }

    public void setIdDiem(Integer idDiem) {
        this.idDiem = idDiem;
    }

    public String getXepLoai() {
        return xepLoai;
    }

    public void setXepLoai(String xepLoai) {
        this.xepLoai = xepLoai;
    }

    public Short getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Short trangThai) {
        this.trangThai = trangThai;
    }

    public Double getDiemGiuaKy() {
        return diemGiuaKy;
    }

    public void setDiemGiuaKy(Double diemGiuaKy) {
        this.diemGiuaKy = diemGiuaKy;
    }

    public Double getDiemCuoiKy() {
        return diemCuoiKy;
    }

    public void setDiemCuoiKy(Double diemCuoiKy) {
        this.diemCuoiKy = diemCuoiKy;
    }

    public Double getDiemKT1() {
        return diemKT1;
    }

    public void setDiemKT1(Double diemKT1) {
        this.diemKT1 = diemKT1;
    }

    public Double getDiemTK2() {
        return diemTK2;
    }

    public void setDiemTK2(Double diemTK2) {
        this.diemTK2 = diemTK2;
    }

    public Double getDiemTK3() {
        return diemTK3;
    }

    public void setDiemTK3(Double diemTK3) {
        this.diemTK3 = diemTK3;
    }

    public Double getDiemTrungBình() {
        return diemTrungBình;
    }

    public void setDiemTrungBình(Double diemTrungBình) {
        this.diemTrungBình = diemTrungBình;
    }

    public Monhoc getIdMonHoc() {
        return idMonHoc;
    }

    public void setIdMonHoc(Monhoc idMonHoc) {
        this.idMonHoc = idMonHoc;
    }

    public Sinhvien getIdSinhVien() {
        return idSinhVien;
    }

    public void setIdSinhVien(Sinhvien idSinhVien) {
        this.idSinhVien = idSinhVien;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiem != null ? idDiem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diem)) {
            return false;
        }
        Diem other = (Diem) object;
        if ((this.idDiem == null && other.idDiem != null) || (this.idDiem != null && !this.idDiem.equals(other.idDiem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.av.pojo.Diem[ idDiem=" + idDiem + " ]";
    }
    
}
