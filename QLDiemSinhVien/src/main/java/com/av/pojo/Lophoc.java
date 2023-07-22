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
@Table(name = "lophoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lophoc.findAll", query = "SELECT l FROM Lophoc l"),
    @NamedQuery(name = "Lophoc.findByIdLopHoc", query = "SELECT l FROM Lophoc l WHERE l.idLopHoc = :idLopHoc"),
    @NamedQuery(name = "Lophoc.findByTenLopHoc", query = "SELECT l FROM Lophoc l WHERE l.tenLopHoc = :tenLopHoc"),
    @NamedQuery(name = "Lophoc.findByKhoaHoc", query = "SELECT l FROM Lophoc l WHERE l.khoaHoc = :khoaHoc")})
public class Lophoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLopHoc")
    private Integer idLopHoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tenLopHoc")
    private String tenLopHoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "khoaHoc")
    private String khoaHoc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maLop")
    private Set<Sinhvien> sinhvienSet;

    public Lophoc() {
    }

    public Lophoc(Integer idLopHoc) {
        this.idLopHoc = idLopHoc;
    }

    public Lophoc(Integer idLopHoc, String tenLopHoc, String khoaHoc) {
        this.idLopHoc = idLopHoc;
        this.tenLopHoc = tenLopHoc;
        this.khoaHoc = khoaHoc;
    }

    public Integer getIdLopHoc() {
        return idLopHoc;
    }

    public void setIdLopHoc(Integer idLopHoc) {
        this.idLopHoc = idLopHoc;
    }

    public String getTenLopHoc() {
        return tenLopHoc;
    }

    public void setTenLopHoc(String tenLopHoc) {
        this.tenLopHoc = tenLopHoc;
    }

    public String getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(String khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    @XmlTransient
    public Set<Sinhvien> getSinhvienSet() {
        return sinhvienSet;
    }

    public void setSinhvienSet(Set<Sinhvien> sinhvienSet) {
        this.sinhvienSet = sinhvienSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLopHoc != null ? idLopHoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lophoc)) {
            return false;
        }
        Lophoc other = (Lophoc) object;
        if ((this.idLopHoc == null && other.idLopHoc != null) || (this.idLopHoc != null && !this.idLopHoc.equals(other.idLopHoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.av.pojo.Lophoc[ idLopHoc=" + idLopHoc + " ]";
    }
    
}
