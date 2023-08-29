/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;

import com.av.pojo.Taikhoan;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import com.av.service.SinhVienService;
import com.av.service.TaiKhoanService;
import com.cloudinary.Cloudinary;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Admin
 */
@ControllerAdvice
@PropertySource("classpath:configs.properties")
@Controller
public class ThongTinStudentController {

    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private SinhVienService tongquanService;
    @Autowired
    private TaiKhoanService taikhoanService;
    @Autowired
    private Environment env;

    @ModelAttribute
    public void comonAttr(Model model) {
        model.addAttribute("sv", new Taikhoan());

    }

    @GetMapping("/sinhvien/thongtin")
    public String thongtin(Model model, @RequestParam Map<String, String> params, Authentication authentication) {
        model.addAttribute("sinhvien", this.tongquanService.getSinhvien(taikhoanService.GetIdTaiKhoan(taikhoanService.getLoggedInUserDetails(authentication))));
        model.addAttribute("taikhoan", this.taikhoanService.getTaiKhoan(taikhoanService.GetIdTaiKhoan(taikhoanService.getLoggedInUserDetails(authentication))));
        return "thongtintaikhoan";
    }

    @PostMapping("/sinhvien/thongtin")
    public String update(@ModelAttribute(value = "sv") Taikhoan p) {
        String errMsg = "";
        if (this.taikhoanService.updateImg(p) == true) {
            errMsg="Cập nhật ảnh thành công!!";
            return "redirect:/sinhvien/thongtin";
        }
        else{
            errMsg="Đã có lỗi!!";
            return "redirect:/sinhvien/thongtin";
        }
    }
}
