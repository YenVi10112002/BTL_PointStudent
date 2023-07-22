/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FPTSHOP
 */
@Entity
@Table(name = "sinhvien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sinhvien.findAll", query = "SELECT s FROM Sinhvien s"),
    @NamedQuery(name = "Sinhvien.findByIdSinhVien", query = "SELECT s FROM Sinhvien s WHERE s.idSinhVien = :idSinhVien"),
    @NamedQuery(name = "Sinhvien.findByHoTen", query = "SELECT s FROM Sinhvien s WHERE s.hoTen = :hoTen"),
    @NamedQuery(name = "Sinhvien.findByHeDaoTao", query = "SELECT s FROM Sinhvien s WHERE s.heDaoTao = :heDaoTao"),
    @NamedQuery(name = "Sinhvien.findByNgaySinh", query = "SELECT s FROM Sinhvien s WHERE s.ngaySinh = :ngaySinh"),
    @NamedQuery(name = "Sinhvien.findByDiaChi", query = "SELECT s FROM Sinhvien s WHERE s.diaChi = :diaChi"),
    @NamedQuery(name = "Sinhvien.findByGioiTinh", query = "SELECT s FROM Sinhvien s WHERE s.gioiTinh = :gioiTinh"),
    @NamedQuery(name = "Sinhvien.findBySoDienThoai", query = "SELECT s FROM Sinhvien s WHERE s.soDienThoai = :soDienThoai"),
    @NamedQuery(name = "Sinhvien.findByEmail", query = "SELECT s FROM Sinhvien s WHERE s.email = :email")})
public class Sinhvien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSinhVien")
    private Integer idSinhVien;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "hoTen")
    private String hoTen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "heDaoTao")
    private String heDaoTao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngaySinh")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "diaChi")
    private String diaChi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gioiTinh")
    private short gioiTinh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "soDienThoai")
    private String soDienThoai;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sinhvien")
    private Set<Diem> diemSet;
    @JoinColumn(name = "maLop", referencedColumnName = "idLopHoc")
    @ManyToOne(optional = false)
    private Lophoc maLop;
    @JoinColumn(name = "idTaiKhoan", referencedColumnName = "idTaiKhoan")
    @ManyToOne
    private Taikhoan idTaiKhoan;

    public Sinhvien() {
    }

    public Sinhvien(Integer idSinhVien) {
        this.idSinhVien = idSinhVien;
    }

    public Sinhvien(Integer idSinhVien, String hoTen, String heDaoTao, Date ngaySinh, String diaChi, short gioiTinh, String soDienThoai, String email) {
        this.idSinhVien = idSinhVien;
        this.hoTen = hoTen;
        this.heDaoTao = heDaoTao;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }

    public Integer getIdSinhVien() {
        return idSinhVien;
    }

    public void setIdSinhVien(Integer idSinhVien) {
        this.idSinhVien = idSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getHeDaoTao() {
        return heDaoTao;
    }

    public void setHeDaoTao(String heDaoTao) {
        this.heDaoTao = heDaoTao;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public short getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(short gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Set<Diem> getDiemSet() {
        return diemSet;
    }

    public void setDiemSet(Set<Diem> diemSet) {
        this.diemSet = diemSet;
    }

    public Lophoc getMaLop() {
        return maLop;
    }

    public void setMaLop(Lophoc maLop) {
        this.maLop = maLop;
    }

    public Taikhoan getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(Taikhoan idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSinhVien != null ? idSinhVien.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sinhvien)) {
            return false;
        }
        Sinhvien other = (Sinhvien) object;
        if ((this.idSinhVien == null && other.idSinhVien != null) || (this.idSinhVien != null && !this.idSinhVien.equals(other.idSinhVien))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.av.pojo.Sinhvien[ idSinhVien=" + idSinhVien + " ]";
    }
    
}
