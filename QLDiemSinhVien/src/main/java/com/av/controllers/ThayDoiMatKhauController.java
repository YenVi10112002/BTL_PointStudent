/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;

import com.av.service.LoginService;
import com.av.service.SinhVienService;
import com.av.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Admin
 */
@Controller
public class ThayDoiMatKhauController {
    
    @Autowired
    private LoginService loService;
    @Autowired
    private SinhVienService tongquanService;
    @Autowired
    private TaiKhoanService taiKhoanService;
    @Autowired
    private Environment env;
    
    @GetMapping("/sinhvien/thaydoimatkhau")
    public String thaydoimatkhau(Model model, Authentication authentication){
         model.addAttribute("taikhoan", this.taiKhoanService.getTaiKhoan(loService.GetIdTaiKhoan(loService.getLoggedInUserDetails(authentication))));
        model.addAttribute("sinhvien", this.tongquanService.getSinhvien(loService.GetIdTaiKhoan(loService.getLoggedInUserDetails(authentication))));
        return "thaydoimatkhau";
    }
}
