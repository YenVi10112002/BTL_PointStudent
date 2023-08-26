/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author Admin
 */
@Entity
@Table(name = "cauhoidiendang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cauhoidiendang.findAll", query = "SELECT c FROM Cauhoidiendang c"),
    @NamedQuery(name = "Cauhoidiendang.findByIdCauHoiDienDan", query = "SELECT c FROM Cauhoidiendang c WHERE c.idCauHoiDienDan = :idCauHoiDienDan"),
    @NamedQuery(name = "Cauhoidiendang.findByNoiDungCauHoi", query = "SELECT c FROM Cauhoidiendang c WHERE c.noiDungCauHoi = :noiDungCauHoi"),
    @NamedQuery(name = "Cauhoidiendang.findByIdTaiKhoan", query = "SELECT c FROM Cauhoidiendang c WHERE c.idTaiKhoan = :idTaiKhoan")})
public class Cauhoidiendang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCauHoiDienDan")
    private Integer idCauHoiDienDan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "noiDungCauHoi")
    private String noiDungCauHoi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTaiKhoan")
    private int idTaiKhoan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCauHoiDienDan")
    @JsonIgnore
    private Set<Traloidiendan> traloidiendanSet;

    public Cauhoidiendang() {
    }

    public Cauhoidiendang(Integer idCauHoiDienDan) {
        this.idCauHoiDienDan = idCauHoiDienDan;
    }

    public Cauhoidiendang(Integer idCauHoiDienDan, String noiDungCauHoi, int idTaiKhoan) {
        this.idCauHoiDienDan = idCauHoiDienDan;
        this.noiDungCauHoi = noiDungCauHoi;
        this.idTaiKhoan = idTaiKhoan;
    }

    public Integer getIdCauHoiDienDan() {
        return idCauHoiDienDan;
    }

    public void setIdCauHoiDienDan(Integer idCauHoiDienDan) {
        this.idCauHoiDienDan = idCauHoiDienDan;
    }

    public String getNoiDungCauHoi() {
        return noiDungCauHoi;
    }

    public void setNoiDungCauHoi(String noiDungCauHoi) {
        this.noiDungCauHoi = noiDungCauHoi;
    }

    public int getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(int idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    @XmlTransient
    public Set<Traloidiendan> getTraloidiendanSet() {
        return traloidiendanSet;
    }

    public void setTraloidiendanSet(Set<Traloidiendan> traloidiendanSet) {
        this.traloidiendanSet = traloidiendanSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCauHoiDienDan != null ? idCauHoiDienDan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cauhoidiendang)) {
            return false;
        }
        Cauhoidiendang other = (Cauhoidiendang) object;
        if ((this.idCauHoiDienDan == null && other.idCauHoiDienDan != null) || (this.idCauHoiDienDan != null && !this.idCauHoiDienDan.equals(other.idCauHoiDienDan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.av.pojo.Cauhoidiendang[ idCauHoiDienDan=" + idCauHoiDienDan + " ]";
    }
    
}
