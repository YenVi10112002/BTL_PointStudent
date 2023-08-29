/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;

import com.av.pojo.Cauhoidiendang;
import com.av.pojo.Traloidiendan;
import java.util.Map;
import com.av.service.SinhVienService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.av.service.DienDanService;
import com.av.service.TaiKhoanService;

/**
 *
 * @author Admin
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:configs.properties")
public class DienDangStudentController {

    @Autowired
    private DienDanService cauhoiServite;
    @Autowired
    private SinhVienService tongquanService;
    @Autowired
    private TaiKhoanService taiKhoanService;
    @Autowired
    private Environment env;

    @ModelAttribute
    public void comonAttr(Model model) {
        model.addAttribute("traloidiendan", new Traloidiendan());
        model.addAttribute("cauhoidiendan", new Cauhoidiendang());

    }

    @RequestMapping("/sinhvien/diendan")
    public String diendan(Model model, @RequestParam Map<String, String> params, Authentication authentication) {
        model.addAttribute("dscauhoi", this.cauhoiServite.getCauHoiDienDan());
        model.addAttribute("taikhoan", this.taiKhoanService.getTaiKhoan(taiKhoanService.GetIdTaiKhoan(taiKhoanService.getLoggedInUserDetails(authentication))));
        model.addAttribute("sinhvien", this.tongquanService.getSinhvien(taiKhoanService.GetIdTaiKhoan(taiKhoanService.getLoggedInUserDetails(authentication))));
        model.addAttribute("traloi", this.cauhoiServite.getTraloi(params));
        model.addAttribute("cauhoi", this.cauhoiServite.getCauHoi(params));
        return "diendansinhvien";
    }

    @PostMapping("/sinhvien/diendan")
    public String add(@ModelAttribute(value = "traloidiendan") Traloidiendan p, @ModelAttribute(value = "cauhoidiendan") Cauhoidiendang a) {
        if (this.cauhoiServite.addOrUpdateTraloi(p) == true || this.cauhoiServite.addOrUpdateCauHoi(a) == true) {
            return "redirect:/sinhvien";
        }
        return "diendansinhvien";
    }
}
