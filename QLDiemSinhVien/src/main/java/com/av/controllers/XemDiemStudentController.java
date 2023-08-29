/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;

import com.av.pojo.Sinhvien;
import com.av.service.DiemService;
import com.av.service.SinhVienService;
import com.av.service.TaiKhoanService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */



@Controller
public class XemDiemStudentController {
    @Autowired
    private SinhVienService sinhVienService;
    @Autowired
    private TaiKhoanService taiKhoanService;
    @Autowired
    private DiemService diemService;
    @Autowired
    private Environment env;

    @ModelAttribute("sinhvien")
    public Sinhvien addSinhVienModelAttribute() {

        return null; 
    }
    
    @GetMapping("/sinhvien/xemdiem")
    public String xemdiem(Model model, Authentication authentication, @ModelAttribute("sinhvien") Sinhvien sinhvien, @RequestParam Map<String, String> params){
        
        sinhvien = this.sinhVienService.getSinhvien(taiKhoanService.GetIdTaiKhoan(taiKhoanService.getLoggedInUserDetails(authentication)));
        model.addAttribute("dsDiem", this.diemService.getListDiem(sinhvien.getIdSinhVien()));
        model.addAttribute("Diemtrungbinh", this.diemService.getDiemTrungBinh(sinhvien.getIdSinhVien()));
        model.addAttribute("Diemtrungbinh4", this.diemService.getDiemTrungBinhHe(sinhvien.getIdSinhVien()));
        model.addAttribute("sinhvien", this.sinhVienService.getSinhvien(taiKhoanService.GetIdTaiKhoan(taiKhoanService.getLoggedInUserDetails(authentication))));
        return "xemdiemsinhvien";
    }
}
