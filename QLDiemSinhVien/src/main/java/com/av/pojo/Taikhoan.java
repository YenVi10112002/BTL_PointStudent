/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.pojo;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FPTSHOP
 */
@Entity
@Table(name = "taikhoan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taikhoan.findAll", query = "SELECT t FROM Taikhoan t"),
    @NamedQuery(name = "Taikhoan.findByIdTaiKhoan", query = "SELECT t FROM Taikhoan t WHERE t.idTaiKhoan = :idTaiKhoan"),
    @NamedQuery(name = "Taikhoan.findByTenTaiKhoan", query = "SELECT t FROM Taikhoan t WHERE t.tenTaiKhoan = :tenTaiKhoan"),
    @NamedQuery(name = "Taikhoan.findByMatKhau", query = "SELECT t FROM Taikhoan t WHERE t.matKhau = :matKhau")})
public class Taikhoan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTaiKhoan")
    private Integer idTaiKhoan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TenTaiKhoan")
    private String tenTaiKhoan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MatKhau")
    private String matKhau;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTaiKhoan")
    private Set<Traloidiendan> traloidiendanSet;
    @JoinColumn(name = "ChucVu", referencedColumnName = "idloaitaikhoan")
    @ManyToOne(optional = false)
    private Loaitaikhoan chucVu;
    @OneToMany(mappedBy = "idTaiKhoan")
    private Set<Giaovu> giaovuSet;
    @OneToMany(mappedBy = "idTaiKhoan")
    private Set<Sinhvien> sinhvienSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTaiKhoan")
    private Set<Cauhoidiendang> cauhoidiendangSet;
    @OneToMany(mappedBy = "idTaiKhoan")
    private Set<Giangvien> giangvienSet;

    public Taikhoan() {
    }

    public Taikhoan(Integer idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public Taikhoan(Integer idTaiKhoan, String tenTaiKhoan, String matKhau) {
        this.idTaiKhoan = idTaiKhoan;
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;
    }

    public Integer getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(Integer idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @XmlTransient
    public Set<Traloidiendan> getTraloidiendanSet() {
        return traloidiendanSet;
    }

    public void setTraloidiendanSet(Set<Traloidiendan> traloidiendanSet) {
        this.traloidiendanSet = traloidiendanSet;
    }

    public Loaitaikhoan getChucVu() {
        return chucVu;
    }

    public void setChucVu(Loaitaikhoan chucVu) {
        this.chucVu = chucVu;
    }

    @XmlTransient
    public Set<Giaovu> getGiaovuSet() {
        return giaovuSet;
    }

    public void setGiaovuSet(Set<Giaovu> giaovuSet) {
        this.giaovuSet = giaovuSet;
    }

    @XmlTransient
    public Set<Sinhvien> getSinhvienSet() {
        return sinhvienSet;
    }

    public void setSinhvienSet(Set<Sinhvien> sinhvienSet) {
        this.sinhvienSet = sinhvienSet;
    }

    @XmlTransient
    public Set<Cauhoidiendang> getCauhoidiendangSet() {
        return cauhoidiendangSet;
    }

    public void setCauhoidiendangSet(Set<Cauhoidiendang> cauhoidiendangSet) {
        this.cauhoidiendangSet = cauhoidiendangSet;
    }

    @XmlTransient
    public Set<Giangvien> getGiangvienSet() {
        return giangvienSet;
    }

    public void setGiangvienSet(Set<Giangvien> giangvienSet) {
        this.giangvienSet = giangvienSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTaiKhoan != null ? idTaiKhoan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taikhoan)) {
            return false;
        }
        Taikhoan other = (Taikhoan) object;
        if ((this.idTaiKhoan == null && other.idTaiKhoan != null) || (this.idTaiKhoan != null && !this.idTaiKhoan.equals(other.idTaiKhoan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.av.pojo.Taikhoan[ idTaiKhoan=" + idTaiKhoan + " ]";
    }
    
}
