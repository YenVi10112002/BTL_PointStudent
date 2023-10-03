/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.pojo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Admin
 */
@Data
public class DiemMonHoc implements Serializable {

    public void setDiemTB(int DiemTB) {
        this.DiemTB = DiemTB;
    }
    private Monhocdangky monHoc;
    private int idMonHocDangKy;
    private String tenMonHoc;
    private int DiemGK = -1;
    private int DiemCK = -1;
    private int DiemKT1 = -1;
    private int DiemKT2 = -1;
    private int DiemKT3 = -1;
    private int DiemTB = -1;
    private String hocKy;
    private int hocKySinhVien;

    public DiemMonHoc(Monhocdangky monHoc) {
        this.monHoc = monHoc;
        this.idMonHocDangKy = monHoc.getIdMonHocDangKy();
        this.hocKySinhVien = monHoc.getIdMonHoc().getIdHocky().getIdHocKy();
        this.hocKy = monHoc.getIdMonHoc().getIdHocky().getTenHocKy();
        this.tenMonHoc = monHoc.getIdMonHoc().getIdMonHoc().getTenMonHoc();
    }

    public DiemMonHoc(int idMonHocDangKy, int DiemGK, int DiemCK, int DiemKT1, int DiemKT2, int DiemKT3) {
        this.idMonHocDangKy = idMonHocDangKy;
        this.DiemGK = DiemGK;
        this.DiemCK = DiemCK;
        this.DiemKT1 = DiemKT1;
        this.DiemKT2 = DiemKT2;
        this.DiemKT3 = DiemKT3;
    }

    public DiemMonHoc() {
        // Constructor mặc định
    }
//    public Monhocdangky getMonHoc() {
//        return monHoc;
//    }

    public void addDiem(Diem diem) {
        switch (diem.getTenDiem().getIdLoaiDiem()) {
            case 1:
                this.setDiemGK((int) diem.getSoDiem());
                break;
            case 2:
                this.setDiemCK((int) diem.getSoDiem());
                break;
            case 3:
                this.setDiemKT1((int) diem.getSoDiem());
                break;
            case 4:
                this.setDiemKT2((int) diem.getSoDiem());
                break;
            case 5:
                this.setDiemKT3((int) diem.getSoDiem());
                break;
            default:
                this.setDiemTB((int) diem.getSoDiem());
                break;
        }
    }

    /**
     * @return the tenMonHoc
     */
    public String getTenMonHoc() {
        return tenMonHoc;
    }

    /**
     * @param tenMonHoc the tenMonHoc to set
     */
    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    /**
     * @return the DiemGK
     */
    public int getDiemGK() {
        return DiemGK;
    }

    /**
     * @param DiemGK the DiemGK to set
     */
    public void setDiemGK(int DiemGK) {
        this.DiemGK = DiemGK;
    }

    /**
     * @return the DiemCK
     */
    public int getDiemCK() {
        return DiemCK;
    }

    /**
     * @param DiemCK the DiemCK to set
     */
    public void setDiemCK(int DiemCK) {
        this.DiemCK = DiemCK;
    }

    /**
     * @return the DiemKT1
     */
    public int getDiemKT1() {
        return DiemKT1;
    }

    /**
     * @param DiemKT1 the DiemKT1 to set
     */
    public void setDiemKT1(int DiemKT1) {
        this.DiemKT1 = DiemKT1;
    }

    /**
     * @return the DiemKT2
     */
    public int getDiemKT2() {
        return DiemKT2;
    }

    /**
     * @param DiemKT2 the DiemKT2 to set
     */
    public void setDiemKT2(int DiemKT2) {
        this.DiemKT2 = DiemKT2;
    }

    /**
     * @return the DiemKT3
     */
    public int getDiemKT3() {
        return DiemKT3;
    }

    /**
     * @param DiemKT3 the DiemKT3 to set
     */
    public void setDiemKT3(int DiemKT3) {
        this.DiemKT3 = DiemKT3;
    }

    /**
     * @return the DiemTB
     */
    public int getDiemTB() {
        return DiemTB;
    }

    /**
     * @param DiemTB the DiemTB to set
     */
}
