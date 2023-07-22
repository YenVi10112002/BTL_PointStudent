/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author FPTSHOP
 */
@Embeddable
public class DiemPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idDiem")
    private int idDiem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSinhVien")
    private int idSinhVien;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMonHoc")
    private int idMonHoc;

    public DiemPK() {
    }

    public DiemPK(int idDiem, int idSinhVien, int idMonHoc) {
        this.idDiem = idDiem;
        this.idSinhVien = idSinhVien;
        this.idMonHoc = idMonHoc;
    }

    public int getIdDiem() {
        return idDiem;
    }

    public void setIdDiem(int idDiem) {
        this.idDiem = idDiem;
    }

    public int getIdSinhVien() {
        return idSinhVien;
    }

    public void setIdSinhVien(int idSinhVien) {
        this.idSinhVien = idSinhVien;
    }

    public int getIdMonHoc() {
        return idMonHoc;
    }

    public void setIdMonHoc(int idMonHoc) {
        this.idMonHoc = idMonHoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDiem;
        hash += (int) idSinhVien;
        hash += (int) idMonHoc;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiemPK)) {
            return false;
        }
        DiemPK other = (DiemPK) object;
        if (this.idDiem != other.idDiem) {
            return false;
        }
        if (this.idSinhVien != other.idSinhVien) {
            return false;
        }
        if (this.idMonHoc != other.idMonHoc) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.av.pojo.DiemPK[ idDiem=" + idDiem + ", idSinhVien=" + idSinhVien + ", idMonHoc=" + idMonHoc + " ]";
    }
    
}
