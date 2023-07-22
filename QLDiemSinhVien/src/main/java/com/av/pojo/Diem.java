/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    @NamedQuery(name = "Diem.findByIdDiem", query = "SELECT d FROM Diem d WHERE d.diemPK.idDiem = :idDiem"),
    @NamedQuery(name = "Diem.findByIdSinhVien", query = "SELECT d FROM Diem d WHERE d.diemPK.idSinhVien = :idSinhVien"),
    @NamedQuery(name = "Diem.findByIdMonHoc", query = "SELECT d FROM Diem d WHERE d.diemPK.idMonHoc = :idMonHoc"),
    @NamedQuery(name = "Diem.findByDiemGiuaKy", query = "SELECT d FROM Diem d WHERE d.diemGiuaKy = :diemGiuaKy"),
    @NamedQuery(name = "Diem.findByDiemCuoiKy", query = "SELECT d FROM Diem d WHERE d.diemCuoiKy = :diemCuoiKy"),
    @NamedQuery(name = "Diem.findByDiemTrungBinh", query = "SELECT d FROM Diem d WHERE d.diemTrungBinh = :diemTrungBinh"),
    @NamedQuery(name = "Diem.findByXepLoai", query = "SELECT d FROM Diem d WHERE d.xepLoai = :xepLoai"),
    @NamedQuery(name = "Diem.findByTrangThai", query = "SELECT d FROM Diem d WHERE d.trangThai = :trangThai")})
public class Diem implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DiemPK diemPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "diemGiuaKy")
    private Double diemGiuaKy;
    @Column(name = "diemCuoiKy")
    private Double diemCuoiKy;
    @Column(name = "diemTrungBinh")
    private Double diemTrungBinh;
    @Size(max = 20)
    @Column(name = "xepLoai")
    private String xepLoai;
    @Column(name = "trangThai")
    private Short trangThai;
    @JoinColumn(name = "idMonHoc", referencedColumnName = "idMonHoc", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Monhoc monhoc;
    @JoinColumn(name = "idSinhVien", referencedColumnName = "idSinhVien", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sinhvien sinhvien;

    public Diem() {
    }

    public Diem(DiemPK diemPK) {
        this.diemPK = diemPK;
    }

    public Diem(int idDiem, int idSinhVien, int idMonHoc) {
        this.diemPK = new DiemPK(idDiem, idSinhVien, idMonHoc);
    }

    public DiemPK getDiemPK() {
        return diemPK;
    }

    public void setDiemPK(DiemPK diemPK) {
        this.diemPK = diemPK;
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

    public Double getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(Double diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
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

    public Monhoc getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(Monhoc monhoc) {
        this.monhoc = monhoc;
    }

    public Sinhvien getSinhvien() {
        return sinhvien;
    }

    public void setSinhvien(Sinhvien sinhvien) {
        this.sinhvien = sinhvien;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diemPK != null ? diemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diem)) {
            return false;
        }
        Diem other = (Diem) object;
        if ((this.diemPK == null && other.diemPK != null) || (this.diemPK != null && !this.diemPK.equals(other.diemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.av.pojo.Diem[ diemPK=" + diemPK + " ]";
    }
    
}
