/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;

import com.av.pojo.Sinhvien;
import com.av.service.DiemService;
import com.av.service.LoginService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.av.service.SinhVienService;
import org.springframework.security.core.Authentication;

/**
 *
 * @author Admin
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:configs.properties")
public class TongQuanController {

    @Autowired
    private SinhVienService sinhvienService;
    @Autowired
    private LoginService loService;
    @Autowired
    private DiemService diemService;
    @Autowired
    private Environment env;

    @ModelAttribute("sinhvien")
    public Sinhvien addSinhVienModelAttribute() {

        return null; 
    }

    @RequestMapping("/sinhvien")
    public String tongquan(Model model, Authentication authentication, @ModelAttribute("sinhvien") Sinhvien sinhvien) {

        sinhvien = this.sinhvienService.getSinhvien(loService.GetIdTaiKhoan(loService.getLoggedInUserDetails(authentication)));
        model.addAttribute("Diemtrungbinh", this.diemService.getDiemTrungBinh(sinhvien.getIdSinhVien()));
        model.addAttribute("Diemtrungbinh4", this.diemService.getDiemTrungBinhHe(sinhvien.getIdSinhVien()));
        model.addAttribute("sinhvien", this.sinhvienService.getSinhvien(loService.GetIdTaiKhoan(loService.getLoggedInUserDetails(authentication))));
        model.addAttribute("dsDiem", this.diemService.getListDiemTrungBinh(sinhvien.getIdSinhVien()));
        return "sinhvien";
    }
}
